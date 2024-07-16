---
description: >-
  As per the recent data from the economic times, In 2023 number of UPI
  transactions are around 117.6 Billion transactions with total value of 182
  lakh crore.
cover: >-
  https://images.unsplash.com/photo-1571867424488-4565932edb41?crop=entropy&cs=srgb&fm=jpg&ixid=M3wxOTcwMjR8MHwxfHNlYXJjaHwzfHxwYXltZW50fGVufDB8fHx8MTcyMTE2MjIwMHww&ixlib=rb-4.0.3&q=85
coverY: 0
---

# 💲 UPI Payment System Design



<figure><img src="../.gitbook/assets/image.png" alt="" width="362"><figcaption><p>Recent Post by NPCI in linkedIn</p></figcaption></figure>

### **Functional Requirements**

* Users can link their bank accounts.
* Users can send and receive money using UPI IDs.
* Users can check their transaction history.
* Users can set a UPI PIN for secure transactions.
* Users can receive notifications for transactions.
* Users can receive payments using scanner.

### **Non Functional Requirements**

* High availability and scalability to handle millions of transactions.
* Low latency to ensure real-time transaction processing.
* Strong security measures to protect sensitive financial data.
* Compliance with regulatory requirements.

<figure><img src="../.gitbook/assets/UPI payment flow.gif" alt=""><figcaption><p>UPI Payment Flow</p></figcaption></figure>

### Envelope Calculations

In Jun 2024, 13.89 Billion transactions with amount of 20.27 Lakh crore with daily avg of 463 million transaction count.&#x20;

Estimated Annual Transactions = 13.89 Billion \* 12 = 166.68 Billion

We have daily average transaction count of 463 Million. But Lets consider peak situation with 1.3 times the average.

So Estimated Daily transactions per day would be around 463 \* 1.3 = 601.9 Million transactions

Number of Transactions per hour: 601.9 / 24 = 25.08 Million&#x20;

Number of Transactions per Second = 6967 ( Approx )

### Capacity Estimations

In this sections we cover mostly about the Database storage requirement, network requirements, Server requirements and Bandwidth calculations.&#x20;

Lets consider the transaction payload.&#x20;

```json
{
  "transactionId": "bc5fcc00-f47d-47b9-a424-5ca0bf93580a",
  "timestamp": "2024-07-17T14:30:00Z",
  "status": "SUCCESS",
  "amount": {
    "currency": "INR",
    "value": 1500.00
  },
  "sender": {
    "upiId": "sender@upi",
    "name": "Sunil Gudivada"
  },
  "receiver": {
    "upiId": "receiver@upi",
    "name": "Asish"
  },
  "note": "Payment for services",
  "metadata": {
    "merchantId": "6a107feb-e9cf-4db1-af27-c6a2e4bbff95",
    "transactionType": "P2P",  // P2P: Peer to Peer, P2M: Peer to Merchant
    "appName": "UPIApp"
  }
}
```

Size of this payload is about 373 B



**Transaction storage calculation**

Daily Storage: 463 Million \* 373 B = 172.7 GB

Monthly Storage: 172.7 \* 30 = 5.18 TB

Yearly storage: 172.7 \* 365 = 63.04 TB



**Network Bandwidth calculation**

**API Call Size:**

Average Request/Response Size: 2 KB (including headers)



**Daily API Traffic:**

API Calls per Transaction: 3 (initiate, process, notify)

Total API Calls: 463 Million \* 3 = 1.389 Billion

Data Transfer per Day: 1.389 Billion \* 2 KB = 2.778 TB



**Peak API Traffic:**

Peak API Calls: 601.9 Million \* 3 = 1.8057 Billion

Data Transfer per Day: 1.8057 Billion \* 2 KB = 3.61 TB



Lets calculate the number of servers required.&#x20;

Assume avg time taken by the request to complete around 50 Millisecond (MS)

Number of api calls at peak hours : 463 Million / 86400 = 5358.81 transactions per second

**Throughput**: 5358.81 \* 50 = 267940.5 RPS



Consider one server is accepting 1000 Request per second

**Number of servers**:  267940.5 / 1000 = 267.9405 = 268 ( API Gateway )



Lets also calculate the number of servers required for the Backend services like User, VPA, Transaction, Bank Integrations.&#x20;

Assume these microservices can process 200 request per second

**Number of servers**:  267940.5/ 200 = 1340 Servers

### Components

<figure><img src="../.gitbook/assets/UPI Payment - System Design Component Checklist.png" alt=""><figcaption><p>UPI Payment System Design - Component Checklist</p></figcaption></figure>

### Tech Stack

NPCI partnered with kyndryls cloud services for **TARM Stack**

_<mark style="background-color:red;">**Below details about the TARM Stack given by chatGPT. May be incorrect.**</mark>_

The TARM stack is an emerging modern web development stack that consists of:

1. **Tigris**: An open-source NoSQL database that supports both key-value and document models. Tigris is designed for high performance and scalability.
2. **Appwrite**: An open-source backend-as-a-service platform that provides a set of APIs to handle authentication, databases, storage, and server-side functions. It's a self-hosted Firebase alternative.
3. **Remix**: A modern JavaScript framework for building robust, dynamic, and SEO-friendly web applications. Remix emphasizes server-side rendering (SSR) and works seamlessly with modern JavaScript tools and libraries.
4. **Meilisearch**: An open-source, fast, and relevant search engine that can be integrated into web applications to provide powerful search functionalities.

#### Key Features and Benefits of TARM Stack:

1. **Scalability and Performance**: Each component in the TARM stack is optimized for high performance and can handle large volumes of data and traffic.
2. **Developer-Friendly**: The stack is designed to be easy to set up and use, with extensive documentation and community support.
3. **Open-Source**: All components are open-source, which provides transparency, flexibility, and cost-effectiveness.
4. **Full-Stack Capabilities**: The stack covers backend, frontend, database, and search functionalities, making it a comprehensive solution for web development.

### References

[https://economictimes.indiatimes.com/industry/banking/finance/total-upi-transactions-cross-100-billion-mark-in-2023/articleshow/106492755.cms?from=mdr](https://economictimes.indiatimes.com/industry/banking/finance/total-upi-transactions-cross-100-billion-mark-in-2023/articleshow/106492755.cms?from=mdr)\
[https://www.npci.org.in/](https://www.npci.org.in/)\
[https://www.itnews.asia/news/indias-npci-modernises-data-centres-using-kyndryls-cloud-services-592061](https://www.itnews.asia/news/indias-npci-modernises-data-centres-using-kyndryls-cloud-services-592061)\
[https://www.tigrisdata.com/](https://www.tigrisdata.com/)\
[https://www.enterpriseitworld.com/kyndryl-to-target-a-market-size-of-530-billion/](https://www.enterpriseitworld.com/kyndryl-to-target-a-market-size-of-530-billion/)\
[https://www.linkedin.com/posts/kyndryl-india\_kyndryl-and-npci-at-bharat-fintech-summit-activity-7029706712915836928-3mIx?utm\_source=share\&utm\_medium=member\_desktop](https://www.linkedin.com/posts/kyndryl-india\_kyndryl-and-npci-at-bharat-fintech-summit-activity-7029706712915836928-3mIx?utm\_source=share\&utm\_medium=member\_desktop)\
