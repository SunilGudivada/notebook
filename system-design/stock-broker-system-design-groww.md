---
cover: >-
  https://images.unsplash.com/photo-1583752028088-91e3e9880b46?crop=entropy&cs=srgb&fm=jpg&ixid=M3wxOTcwMjR8MHwxfHNlYXJjaHw3fHxzdG9ja3xlbnwwfHx8fDE3MjEyMzk2MzZ8MA&ixlib=rb-4.0.3&q=85
coverY: 0
---

# 📈 Stock Broker System Design - Groww

## Introduction

lets first try to understand **what stock broker is** ?

Stock brokers are authorized members of the stock exchanges (i.e. BSE, NSE).

They execute trades on behalf of the customers at the exchange. There are 100's of registered stock brokers in India offering stock trading to retail customers. At high-level, the **most famous stock brokers in India** are categories in 2 types:

1. Full-services brokers
2. Discount Stock Brokers

**Full-service brokers** offer a wide range of services including stock trading, research and advisory and local support. **Discount stock brokers** are online brokers specialized only in stock and commodity trading services. They do not offer add-ons like research and advisory, PMS, wealth management and branch support.

The **most popular stock brokers** in the full-service category include ICICI Direct, Sharekhan, HDFC Securities, Sharekhan, Angel One and Axis Bank. The **most famous stock brokers** in discount broker category include Zerodha, 5paisa, Groww and upstox.

We can't read system design for all the brokers but lets consider one by more number of clients .

<table><thead><tr><th>Stock Broker</th><th>Number of Clients ( In Millions )</th><th data-hidden></th></tr></thead><tbody><tr><td>Groww</td><td>9.19</td><td></td></tr><tr><td>Zerodha</td><td>7.22</td><td></td></tr><tr><td>Angel One</td><td>5.98</td><td></td></tr><tr><td>Upstox</td><td>2.4</td><td></td></tr></tbody></table>

<figure><img src="../.gitbook/assets/image.png" alt="" width="188"><figcaption><p>Groww System Design</p></figcaption></figure>

## Functional requirements

* Price Changes are frequent in fractions of seconds.
* Buy / Sell Order placement
* Portfolio Management
* Trade history & Reporting
* Notification & alerts
* Order Matching Engine

## Non Functional requirements

* High availability and reliability.
* Low latency for real-time transactions.
* Scalability to handle high volumes of trade requests.
* Security to protect user data and transactions.
* Compliance with financial regulations.

## Architecture Diagram

<figure><img src="../.gitbook/assets/Stock Broker System Design - Architechture Diagram.gif" alt=""><figcaption><p>Stock Broker System design</p></figcaption></figure>

## List of Microservices

Considering the system like groww, it is good to have each microservices for single major functionality. There will be huge data flow in and out. Failures in one service do not necessarily impact others, improving system reliability. Having decoupling between the service dependencies, allows more flexibility and resilient architecture. &#x20;

Below are the list of services required considering the above functionality. I am dividing the functionality into three categories. ( Core, Infra, Optional )

**Core:** These are the microservices specific to the grow as a company or product.

<table><thead><tr><th width="304">Microservice</th><th>Description</th></tr></thead><tbody><tr><td>Market Service</td><td>Provides real-time market data to users</td></tr><tr><td>Order Service</td><td>Handles the creation, modification, and cancellation of buy/sell orders</td></tr><tr><td>Portfolio Service</td><td>Manages users’ portfolios and investments</td></tr><tr><td>Trade History Service</td><td>Stores and retrieves historical trade data</td></tr><tr><td>Trade Execution Service</td><td>Executes buy/sell orders by communicating with stock exchanges like NSE / BSE</td></tr><tr><td>Order Matching Engine Service</td><td>Matches buy and sell orders within the system. <mark style="background-color:yellow;">This is required for internal order processing and execution efficiency.</mark></td></tr><tr><td>Price Update Service</td><td>Handles frequent price updates and broadcasts them to users</td></tr><tr><td>Real-time Data Processing Service</td><td>Processes real-time data streams for market data and order execution</td></tr></tbody></table>

**Infra:** These are the services required to run any kind of product. These services will be helpful when company / startup need for diversion from the existing path.&#x20;

<table><thead><tr><th width="305">Microservice</th><th>Description</th></tr></thead><tbody><tr><td>Identity Service</td><td>Manages user profiles, authentication, and authorization</td></tr><tr><td>Logging and Monitoring Service</td><td>Logs system activities and monitors system health</td></tr><tr><td>Payment Service</td><td>Manages financial transactions and settlements</td></tr><tr><td>API Gateway Service</td><td>Provides a unified entry point for client applications</td></tr></tbody></table>

**Optional:** These services are good to have for a system. <mark style="background-color:yellow;">Cover these services only if time permits in the interview.</mark>&#x20;

<table><thead><tr><th width="305">Microservice</th><th>Description</th></tr></thead><tbody><tr><td>Audit, Compliance Service</td><td>Ensures the system complies with regulatory requirements</td></tr><tr><td>Customer Support Service</td><td>Manages customer support requests and issues</td></tr><tr><td>User Preferences Service</td><td>Stores and manages user preferences and settings</td></tr><tr><td>Fraud Detection Service</td><td>Detects and prevents fraudulent activities</td></tr></tbody></table>

### User Distribution

Let's assume different percentages of active users for each microservice, considering typical usage patterns.

1. **Order Service**: 30% of active clients.
2. **Portfolio Service**: 20% of active clients.
3. **Trade History Service**: 10% of active clients.
4. **Trade Execution Service**: 10% of active clients.
5. **Order Matching Engine**: Tied to order service, hence 30% of active clients.
6. **Price Update Service**: 10% of active clients, with updates for 5 companies each.
7. **Market Data Service**: 100% of companies (7,800).

## Envelope Calculations

As of March 2024, Companies registered are as follows

BSE: 5421

NSE: 2379

Total companies are around: 7800

<mark style="background-color:red;">Note: There can be companies listed in both. We are not considering this corner case.</mark>&#x20;

#### Assumptions

| Description                            | Value                               |
| -------------------------------------- | ----------------------------------- |
| Total Users ( Groww )                  | 9.19 million                        |
| Registered Companies ( NSE and BSE )   | 7800                                |
| Trading hours in a day                 | 9:15 AM to 3:30 PM (22,500 seconds) |
| Trading days in the month              | 22                                  |
| API Call Average Request/Response Size | 2 KB including headers              |
| Average Request Processing Time        | 50 ms                               |
| Max Requests per Server                | 1000                                |
| Max Websockets per Server              | 20,000                              |

### Market Service

**Assumptions**

| Description                 | Value                            |
| --------------------------- | -------------------------------- |
| Company Updates Per second  | 5 updates per company per second |
| Data per Update             | 0.1 KB (100 bytes)               |
| Total Companies             | 7,800                            |
| Websocket Update Required ? | No                               |

**Storage Calculation**

Total Updates per Trading Day: 7800 \* 22500 = 175,500,000 Updates / day

Data per Trading Day: 175,500,000 \* 0.5 KB = **87.75 GB / day**

Total data per month (Assuming 22 days of trading): 16.73 GB \* 22 = <mark style="background-color:green;">**1930.5 GB / Month**</mark>&#x20;



**Servers Calculation**

#### **Market Data Ingestion**

**Total Updates per Second**: 7,800 companies \* 5 updates/sec = 39,000 updates/sec

**Number of API Servers**: 39,000 / 1000 = <mark style="background-color:green;">**39 servers**</mark>

***

### **Order Service and Order Matching Service**

**Assumptions**

| Description             | Value                    |
| ----------------------- | ------------------------ |
| Orders per User per Day | 2 orders                 |
| Data per Order          | 2 KB                     |
| Active Users            | 30% of 919,000 = 275,700 |

**Storage Calculation**

Total Orders per Trading Day: 9.19 m \* 2 = 18.38 million orders per day

Data per Trading Day: 18.38 \* 2 = **36.76 GB / day**

Total Data per month: 18.38 \* 22 = <mark style="background-color:green;">**808.72 GB / month**</mark>



**Server Calculation**

API Requests per second = 275,700 / 0.05 = 5,514,000 requests/sec

Number of API Servers = 5,514,000 / 1000 = <mark style="background-color:green;">**5514 servers**</mark>

Number of Websocket Servers = 275,700 ​/ 20,000 = 13.785 = <mark style="background-color:green;">**14 ( Approx)**</mark>

***

### **Portfolio Service**

**Assumptions**

| Description              | Value                    |
| ------------------------ | ------------------------ |
| Updates per User per Day | 5                        |
| Data per update          | 1 KB                     |
| Active Users             | 20% of 919,000 = 183,800 |

**Storage Calculation**

Total portfolio updates per Trading Day: 9.19 m \* 5= 45.94 million updates / day

Data per Trading Day: 45.95 m \* 1 KB = **45.95 GB / day**

Total data per month (Assuming 22 days of trading): 45.95 GB \* 22 = <mark style="background-color:green;">**1,010.9 GB / Month**</mark>&#x20;



**Server Calculation**

API Requests per second = 183,800 / 0.05 = 3,676,000 requests/sec

Number of API Servers = 3,676,000 / 1000 = <mark style="background-color:green;">**3676 servers**</mark>

***

### **Trade History Service and Trade Execution Service**&#x20;

**Assumptions**

| Description             | Value                   |
| ----------------------- | ----------------------- |
| Trades per User per Day | 2                       |
| Data per Trade          | 2 KB                    |
| Active Users            | 10% of 919,000 = 91,900 |

**Storage Calculations:**

Total trades per Trading Day: 9.19 m \* 2 = 18.38 million updates / day

Data per Trading Day: 18.38m \* 2 KB = **36.76 GB / day**

Total data per month (Assuming 22 days of trading): 36.76 GB \* 22 = <mark style="background-color:green;">**808.72 GB / Month**</mark>&#x20;



**Server Calculations:**

API Requests per second = 91,900 / 0.05 = 1,838,000 requests/sec

Number of API Servers = 1,838,000 / 1000 = <mark style="background-color:green;">**1838 servers**</mark>

Number Of Websocket Servers = 1,838,000 / 20,000 = 91.9 = <mark style="background-color:green;">**92 Servers**</mark>

***

### **Price Update Service**

**Assumptions**

| Description                      | Value                   |
| -------------------------------- | ----------------------- |
| Price Updates per second         | 1000                    |
| Data per Update                  | 0.1 KB                  |
| Number of price updates per user | 5                       |
| Number of active Users           | 10% of 919,000 = 91,900 |

**Storage Calculations**

Total updates per Trading Day: 1000 \* 22,500 = 22,500,000 updates / day

Data per Trading Day: 22,500,000 \* 0.1 KB = **22,500 KB / day = 2.25 GB / day**

Total data per month (Assuming 22 days of trading): **2.25** GB \* 22 = <mark style="background-color:green;">**49.5 GB / Month**</mark>&#x20;



**Server Calculations**

Total Price Updates: 91,900 \* 5 = 459,500 updates/sec

API Requests per second = 459,500 / 0.05 = 9,190,000 requests/sec

Number of API Servers = 9,190,000 / 1000 = <mark style="background-color:green;">**9190 servers**</mark>

Number of Websocker servers = 9,190,000 / 20,000 = 459.5 = <mark style="background-color:green;">460 ( Approx)</mark>

### **Real-time Data Processing Service**

**Storage Calculations**

Market Data Updates: 39,000 updates/sec

Updates Stored per Second: 1% of 39,000 updates/sec = 390 updates/sec

Total Data Size per Second: 390  \* 0.01 = 3.9 KB/sec

Total Data Size per Day: 3.90 KB/sec \* 22,500 = 87.75 MB /day

Total Data Size per Month: 87.75  \* 22 = 1.93 GB /month



**Server Calculations**

* **Market Data Ingestion**:
  * **Active Companies**: 7,800
  * **Market Data Updates**: Assume 5 updates per second per company
  * **Total Updates per Second**: 7800 \* 5 = 39,000 updates/sec\

* **Data Aggregation and Transformation**:
  * Assume each update requires 1 additional processing step
  * **Total Processing Steps per Second**: 39,000\

* **Event Detection**:
  * Assume 10% of updates trigger events
  * **Event Detection Steps per Second**: 0.1 \* 39,000 = 3,900\

* **Streaming Updates**:
  * Assume each update is sent to 30% of active users (30% of 919,000)
  * **Active Users Receiving Updates**: 0.3 \* 919,000 = 275,700
  * **Updates per User per Second**: 2 (assume each user receives updates for 2 companies)
  * **Total Streaming Updates per Second**: 275,700 \* 2 = 551,400 updates/sec\

* **Data Storage**:
  * Assume 1% of updates are stored for historical analysis
  * **Data Storage Steps per Second**: 0.01 \* 39,000 = 390

**Total Updates:**

39,000 + 39,000 + 3,900 + 390 = 82,290 updates/sec

Number of API servers: 82,290 / 1000 = 82.2 = <mark style="background-color:green;">**83 ( Approx )**</mark>

Number of Websocket Servers: 551,400 / 20, 000 = <mark style="background-color:green;">**28 Servers**</mark>&#x20;



### Total Servers

{% embed url="https://docs.google.com/spreadsheets/d/10tRHqicAgEYT-YYuiOAJ2Gs1Wz6CtADMksl7ZoS8up4/edit?usp=sharing" fullWidth="false" %}
Envelope Calculation
{% endembed %}

**Total Storage Required =** 6227.71 GB / Month

**Total API servers:** 27, 692 per second

**Total Websocket servers**: 608 per second

## Component Design

<div data-full-width="true">

<figure><img src="../.gitbook/assets/Groww Stock broker - System Design.png" alt=""><figcaption><p>Groww System design components</p></figcaption></figure>

</div>

## References

[https://www.chittorgarh.com/report/top\_20\_share\_brokers\_in\_india\_by\_clients\_at\_nse/1/](https://www.chittorgarh.com/report/top\_20\_share\_brokers\_in\_india\_by\_clients\_at\_nse/1/)\
[https://www.statista.com/statistics/1056499/india-leading-equity-brokerage-firms-by-active-customers/](https://www.statista.com/statistics/1056499/india-leading-equity-brokerage-firms-by-active-customers/)\
[https://www.nseindia.com/regulations/listing-compliance/nse-market-capitalisation-all-companies](https://www.nseindia.com/regulations/listing-compliance/nse-market-capitalisation-all-companies)\
\
[https://blog.shoonya.com/how-many-companies-are-listed-in-nse-and-bse/#:\~:text=There%20are%20a%20total%20of%205%2C309%20listed%20companies,DVRs%2C%20REITs%2C%20InVITs%2C%20ETFs%2C%20and%20Partly%20Paid%20Shares.](https://blog.shoonya.com/how-many-companies-are-listed-in-nse-and-bse/)[https://cloud.google.com/customers/groww#:\~:text=Groww%3A%20Empowering%20investors%20with%20a,platform%20powered%20by%20Google%20Clou](https://cloud.google.com/customers/groww)[https://stackshare.io/groww/groww](https://stackshare.io/groww/groww)\
[https://tech.groww.in/](https://tech.groww.in/)
