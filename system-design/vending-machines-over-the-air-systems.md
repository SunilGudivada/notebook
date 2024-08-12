---
cover: >-
  https://images.unsplash.com/photo-1575224526797-5730d09d781d?crop=entropy&cs=srgb&fm=jpg&ixid=M3wxOTcwMjR8MHwxfHNlYXJjaHwzfHx2ZW5kaW5nfGVufDB8fHx8MTcyMzQ1MTIzM3ww&ixlib=rb-4.0.3&q=85
coverY: 0
---

# 🌳 Vending Machines - Over the air Systems

## Introduction

**What are over the air update systems?**&#x20;

Over the air update systems are also known as the over the air programming, it is an update to the embedded system delivered though a wireless network.

There is also a term called FOTA - Firmware over the air. Updating the firmware over the air is called FOTA.

Before OTA, embedded systems were flashed only through direct physical access or wired connections.

Here are some examples from Bing Copilot:

1. **Smartphones**: Both iOS and Android devices receive OTA updates for their operating systems, apps, and security patches.
2. **Automobiles**: Modern cars, especially those from manufacturers like Tesla and BMW, receive OTA updates for their infotainment systems, navigation, and even firmware updates for vehicle components.
3. **Internet of Things (IoT) Devices**: Smart home devices, such as thermostats, security cameras, and smart speakers, often receive OTA updates to improve functionality and security.
4. **Telecommunications Equipment**: Network devices like routers and modems receive OTA updates to enhance performance and security

**Vending Machines** fall into the category of **IOT devices**. These machines are part of the broader IoT ecosystem, where devices are connected to the internet and can communicate with each other and with central systems to receive updates, manage inventory, and enhance functionality.

**During the interview, please follow the below steps:**&#x20;

🔹 Understand the Problem\
🔸 Define the Scope and Requirements\
🔹 Identify Functional and Non-Functional Requirements\
🔸 High-Level System Design\
🔹 Component Design and Interaction\
🔸 Scalability and Reliability\
🔹 Security Considerations\
🔸 Monitoring and Maintenance\
🔹 Trade-offs and Considerations

## **Problem Statement**&#x20;

Design a vending machine that can dispense products upon receiving the payment

Key considerations are product selection, payment processing, dispensing mechanism and inventory management.&#x20;

Below are the list of questions to ask yourself:

* What is the primary goal ?&#x20;
* Who are the users ?&#x20;
* what are the key use cases ?&#x20;

## Scope and requirements&#x20;

**Functional requirements:**&#x20;

* Based on the inventory management, display the available products in the machine and show the products and prices in the app after scanning the inventory management.\\
* Accept Multiple payment methods
* Dispense the selected products after successful payment
* Track and manage inventory in real-time.

**Non-Functional requirements:**

High Availability and reliability

Secure transactions

Remote Monitoring capability



## **Identify Functional and Non-Functional Requirements**

**Functional:** Payment processing, product selection, dispensing mechanism, and inventory updates.

**Non-Functional:** System availability, payment security, ease of use, and remote monitoring.



## Envelope calculations

Data Assumptions:&#x20;

Number of vending machines: 200

Number of different products: 25 per vending machine

Transactions per machine per hour: 20

Average size of each transaction: 1KB

Average size of product inventory: 1KB



Total number of transactions per hour = 200 \* 20 = 4000

Transactions across machines = 96,000



## **High Level Design**&#x20;

1. **Inventory Management service**: As the name suggests to maintain the inventory across all the 200 vending machines
2. **Product Real time view service**: Display variety of products and their prices in real time. This will be integrated in the mobile app to show the products after scanning the machine.&#x20;
3. **Payment Processing service**: As the name suggests to process and secure the payment integration with external gateways
4. **Dispensing service**: Communicates with hardware to dispense the items based on the payment status.
5. **Remote Monitoring service**: Provides the real time monitoring of all the machines, including the inventory management, machine health, transaction status
6. **Transaction logging service**: Logs all the transactions including payment successful or failed attempts. This is also responsible for maintaining the history of all interaactions and transactions.&#x20;
7. **Identity Management service**: Manages the user authentication for mobile app access.
8. **Analytics service**: Provides insights into product sales, machine usage and user behaviour. Supports business intelligence for restocking and few marketing insights.

## &#x20;Trade-offs and Considerations&#x20;

CAP theorem states that in any distributed system, it is impossible to simultaneously guarantee all three of the following properties:

1. **Consistency (C):** Every read receives the most recent write or an error.
2. **Availability (A):** Every request (read or write) receives a response, without guarantee that it contains the most recent write.
3. **Partition Tolerance (P):** The system continues to operate despite network partitions (communication breaks between nodes).

[cap-theorem.md](key-concepts/cap-theorem.md "mention")

For the vending machine system, the CAP theorem applies as follows:

#### 1. **Partition Tolerance:**

Partition tolerance is a necessary property for any distributed system, especially when dealing with physical vending machines that may be located in different regions or connected over potentially unreliable networks. The system must be able to handle temporary network failures without crashing. This is non-negotiable in distributed systems.

#### 2. **Consistency vs. Availability:**

**Consistency:** Ensuring that every read reflects the most recent write is crucial for certain operations, like maintaining accurate inventory levels and ensuring that payments are correctly processed. However, in cases where the network is partitioned, insisting on consistency might mean that the system cannot respond to requests (leading to unavailability).

**Availability :** Ensuring that the vending machine always responds to user requests (e.g., dispensing a product, accepting payments) is also critical. If the system prioritizes availability, it might serve slightly stale data or accept payments even if there is a temporary inconsistency in the inventory count.

#### **Applicable Choices:**

Given the nature of a vending machine system, it must balance consistency and availability but can only fully guarantee one under partition conditions:

**In a Scenario Favoring Availability:**

The system ensures that the vending machine remains operational and responsive even if it cannot guarantee that the inventory count is perfectly accurate. This might mean accepting a payment even if the inventory count hasn't been synchronized across all nodes, risking an "out of stock" situation that needs to be rectified later.

_This is crucial because vending machines need to be always available to users, especially in locations where network connectivity might be unreliable._

**In a Scenario Favoring Consistency:**

The system could enforce strict inventory synchronization, ensuring that users are never charged for products that are not available. This might come at the cost of availability, where the machine could become temporarily unavailable if the system cannot confirm the latest state due to a network partition.

_This might be acceptable in environments where vending machine users expect high reliability in inventory reporting, but it risks frustrating users during network issues._

**My recommendation:**&#x20;

For a vending machine system, **Partition Tolerance and Availability** are often prioritized over strict Consistency. The reasoning is that vending machines need to be operational and responsive to user interactions at all times, even if that occasionally means dealing with slight inconsistencies in inventory data or transaction logs. The system would likely aim for **eventual consistency**, where data inconsistencies are resolved over time, ensuring that the machine remains available during network issues.

## References

[https://en.wikipedia.org/wiki/Over-the-air\_update](https://en.wikipedia.org/wiki/Over-the-air\_update)

[https://vendingmachineindia.in/big-basket-vending-machine/](https://vendingmachineindia.in/big-basket-vending-machine/)

[https://www.geeksforgeeks.org/vending-machine-high-level-system-design/](https://www.geeksforgeeks.org/vending-machine-high-level-system-design/)\
\
[https://www.trio.so/blog/over-the-air-update/](https://www.trio.so/blog/over-the-air-update/)\
\
[https://jfrog.com/connect/post/ota-updates-for-remote-devices-different-methods-explained/](https://jfrog.com/connect/post/ota-updates-for-remote-devices-different-methods-explained/)\
\
[https://support.toyota.com/s/article/21MM-OvertheAir-Softw-10738?language=en\_US](https://support.toyota.com/s/article/21MM-OvertheAir-Softw-10738?language=en\_US)\
\
[https://www.android.com/auto/](https://www.android.com/auto/)\
\
[https://www.vendsoft.com/](https://www.vendsoft.com/)
