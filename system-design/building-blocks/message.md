---
cover: >-
  https://images.unsplash.com/photo-1574169207341-6c2aebfa8ae2?crop=entropy&cs=srgb&fm=jpg&ixid=M3wxOTcwMjR8MHwxfHNlYXJjaHw0fHxmbG93fGVufDB8fHx8MTcyMTc0MTMxOXww&ixlib=rb-4.0.3&q=85
coverY: 0
---

# 🔹 Message

## Introduction

In the modern distributed systems, Asynchronous messaging options are broadly classified into the categories below.&#x20;

* Message queues
* Pub/sub systems
* Event streaming platforms
* Event routing and processing services
* Stream processing services
* Enterprise messaging systems&#x20;
* Managed messaging services

<details>

<summary>Producer can directly communicate with Consumer, but why do we need intermediate step message broker? </summary>

_/Response from ChatGPT_

* **Decoupling**:
  * **Independence**: Producers and consumers can operate independently without needing to know each other’s specifics. This decoupling allows for easier maintenance and updates since changes in one component do not necessitate changes in the other.
  * **Scalability**: Producers and consumers can be scaled independently based on their load requirements.

<!---->

* **Reliability**:
  * **Message Persistence**: Message brokers can persist messages to ensure they are not lost in case of a failure. This is crucial for maintaining data integrity in distributed systems.
  * **Retry Mechanisms**: Brokers can manage message retries, ensuring that messages are delivered even if the consumer temporarily goes down.

<!---->

* **Load Balancing**:
  * **Distributed Load**: Brokers can distribute the load among multiple consumers, preventing any single consumer from becoming a bottleneck.
  * **Backpressure Handling**: Brokers can manage backpressure by queuing messages when the consumer is overwhelmed, thus preventing system crashes due to overload.

<!---->

* **Flexibility**:
  * **Message Routing**: Brokers can route messages based on various criteria such as content, topic, or headers, allowing complex communication patterns like publish-subscribe, request-reply, and fan-out.
  * **Transformation**: Some brokers can transform messages, ensuring compatibility between different versions of producers and consumers.

<!---->

* **Resilience**:
  * **Fault Tolerance**: Brokers often come with built-in fault tolerance, allowing systems to continue operating smoothly even when some components fail.
  * **Failover**: In case a consumer fails, the broker can redirect messages to another available consumer.

<!---->

* **Monitoring and Management**:
  * **Metrics and Logging**: Message brokers provide detailed metrics and logging capabilities, allowing for better monitoring and debugging of the system.
  * **Throttling**: Brokers can throttle message delivery to consumers, preventing system overload.

<!---->

* **Security**:
  * **Access Control**: Brokers can enforce access control policies, ensuring that only authorized producers and consumers can communicate.
  * **Encryption**: Brokers can handle message encryption, ensuring data privacy and integrity during transmission.

</details>

Let's go through all the services categories.&#x20;

First let me clarify why there are distinct categories. We can classify messages into two.

* If the producer expects an action from the consumer, that message is a _command_.&#x20;
* If the message informs the consumer that an action has taken place, then the message is an _event_.

**Understand your requirement clearly and then go for which messaging system to use.**&#x20;

Now lets go through all the categories once and identify what all the different cloud providers are providing.

<figure><img src="../../.gitbook/assets/Asynchronous messaging.gif" alt=""><figcaption></figcaption></figure>

## **Message Queues**

Message queues allow for decoupled communication between producers and consumers, ensuring reliable message delivery and processing.

* [**Amazon SQS (Simple Queue Service)**](https://docs.aws.amazon.com/AWSSimpleQueueService/latest/SQSDeveloperGuide/welcome.html): Fully managed queuing service supporting standard and FIFO queues.
* [**Azure Queue Storage**](https://learn.microsoft.com/en-us/azure/storage/queues/storage-quickstart-queues-dotnet?tabs=passwordless%2Croles-azure-portal%2Cenvironment-variable-windows%2Csign-in-azure-cli): Simple message queuing for large numbers of messages.
* [**Google Cloud Tasks**](https://cloud.google.com/tasks/docs): Task scheduling and execution service.
* [**IBM MQ**](https://www.ibm.com/products/mq): Enterprise-grade messaging middleware.
* [**RabbitMQ**](https://www.rabbitmq.com/docs): Open-source message broker supporting multiple messaging protocols.
* [**Apache ActiveMQ**](https://activemq.apache.org/): Open-source message broker with support for JMS and other protocols.

### Use Cases

**Use Case 1: Order Processing System**

* **Scenario**: An e-commerce platform processes customer orders.
* **Implementation**: When a customer places an order, it is placed in a message queue (e.g., Amazon SQS). A pool of worker applications (consumers) retrieves orders from the queue, processes payments, updates inventory, and generates shipping labels. This decoupling ensures that order submission is fast and reliable, and the processing workload is distributed.

**Use Case 2: Email Notification Service**

* **Scenario**: A web application sends email notifications for various user activities (e.g., sign-up, password reset).
* **Implementation**: User actions trigger messages to be sent to a queue (e.g., Azure Queue Storage). An email service retrieves messages from the queue and sends out the emails. This ensures that email sending does not block the user’s primary action and provides resilience and scalability.

***

## **Publish/Subscribe (Pub/Sub) Systems**

Pub/Sub systems enable broadcasting messages to multiple subscribers, allowing for scalable and flexible message distribution.

* [**Amazon SNS**](https://docs.aws.amazon.com/sns/) **(Simple Notification Service)**: Fully managed pub/sub messaging service.
* [**Google Cloud Pub/Sub**](https://cloud.google.com/pubsub/docs/overview): Real-time messaging service for event ingestion and delivery.
* [**Azure Service Bus**](https://learn.microsoft.com/en-us/azure/service-bus-messaging/service-bus-messaging-overview): Supports pub/sub through topics and subscriptions.
* [**Kafka**](https://kafka.apache.org/documentation/#gettingStarted): Distributed streaming platform suitable for high-throughput pub/sub.
* [**Redis Pub/Sub**](https://redis.io/docs/latest/develop/interact/pubsub/): In-memory data structure store with pub/sub capabilities.

### Use cases

**Use Case 1: Real-Time News Feed**

* **Scenario**: A social media platform updates users' news feeds in real-time.
* **Implementation**: User activities (e.g., posting, liking) generate events that are published to a pub/sub system (e.g., Google Cloud Pub/Sub). Subscribers (news feed services) receive these events and update the relevant users’ feeds instantly, ensuring that users see updates in real-time.

**Use Case 2: IoT Data Aggregation**

* **Scenario**: An IoT solution collects data from various sensors.
* **Implementation**: Sensors publish data to an MQTT broker (e.g., RabbitMQ with MQTT plugin). Multiple services subscribe to specific topics to process and analyze sensor data for various purposes like monitoring, alerting, and analytics.

***

## **Event Streaming Platforms**

Event streaming platforms handle high-volume, real-time data streams for analytics and processing.

* [**Apache Kafka**](https://kafka.apache.org/documentation/#gettingStarted): High-throughput, low-latency platform for distributed streaming.
* [**Amazon MSK**](https://docs.aws.amazon.com/msk/latest/developerguide/getting-started.html?refid=0c835ec3-3fbf-4e72-802c-19a02d6e2337) **(Managed Streaming for Apache Kafka)**: Fully managed Kafka service.
* [**Azure Event Hubs**](https://learn.microsoft.com/en-us/azure/event-hubs/): Big data streaming platform and event ingestion service.
* [**Confluent Cloud**](https://www.confluent.io/confluent-cloud/): Managed Kafka service by Confluent.
* [**IBM Event Streams**](https://www.ibm.com/products/event-streams): Managed Kafka service by IBM.
* [**Red Hat AMQ Streams**](https://www.redhat.com/en/resources/amq-streams-datasheet): Kubernetes-native Kafka platform.

### Use Cases

**Use Case 1: Fraud Detection in Financial Transactions**

* **Scenario**: A financial institution monitors transactions for fraudulent activity.
* **Implementation**: Transactions are streamed to a platform like Apache Kafka. A stream processing engine analyzes the data in real-time to detect patterns indicating fraud. Suspicious transactions trigger alerts or automated actions like account holds.

**Use Case 2: Clickstream Analysis**

* **Scenario**: An e-commerce website analyzes user behavior for personalized recommendations.
* **Implementation**: User interactions are streamed to Amazon MSK (Managed Streaming for Apache Kafka). Real-time analytics are performed to track user journeys and behavior, enabling personalized product recommendations and targeted advertising.

***

## **Event Routing and Processing**

Event routing and processing services manage event-driven architectures by routing and processing events from various sources.

* [**Azure Event Grid**](https://learn.microsoft.com/en-us/azure/event-grid/overview): Fully managed event routing service for building event-driven applications.
* [**AWS EventBridge**](https://docs.aws.amazon.com/eventbridge/latest/userguide/eb-what-is.html): Event bus for routing events between AWS services and custom applications.
* [**Google Cloud Functions**](https://cloud.google.com/functions#documentation): Event-driven serverless compute service for lightweight processing.
* [**AWS Lambda**](https://aws.amazon.com/lambda/resources/): Serverless compute service triggered by events from other AWS services.

### Use Cases

**Use Case 1: Serverless Event-Driven Architecture**

* **Scenario**: An application integrates multiple microservices that need to respond to various events.
* **Implementation**: Azure Event Grid routes events (e.g., file uploads to Azure Blob Storage) to Azure Functions that process these events (e.g., image processing, data validation). This architecture allows for efficient, scalable, and decoupled event handling.

**Use Case 2: Real-Time Inventory Management**

* **Scenario**: A retail chain manages inventory levels in real-time across multiple stores.
* **Implementation**: AWS EventBridge captures inventory events from different stores and routes them to Lambda functions that update the central inventory system. This ensures that the inventory data is always up-to-date and accurate.

***

## **Stream Processing**

Stream processing services allow for real-time data analytics and transformation.

* [**Azure Stream Analytics**](https://learn.microsoft.com/en-us/azure/stream-analytics/stream-analytics-stream-analytics-query-patterns): Real-time data stream processing with SQL-based query language.
* [**AWS Kinesis Data Streams**](https://docs.aws.amazon.com/streams/latest/dev/introduction.html): Real-time data streaming service.
* [**Google Cloud Dataflow**](https://cloud.google.com/dataflow#stream-analytics): Fully managed service for real-time stream and batch processing.
* [**Apache Flink**](https://nightlies.apache.org/flink/flink-docs-stable/): Open-source stream processing framework.
* [**Apache Storm**](https://storm.apache.org/releases/2.6.2/index.html): Distributed real-time computation system.

### Use Cases

**Use Case 1: Social Media Sentiment Analysis**

* **Scenario**: A company tracks social media mentions to gauge public sentiment.
* **Implementation**: Social media feeds are ingested into Azure Event Hubs. Azure Stream Analytics processes these streams in real-time to analyze sentiment and generates insights, which are then visualized in Power BI dashboards.

**Use Case 2: Predictive Maintenance for Manufacturing**

* **Scenario**: A manufacturing plant predicts equipment failures to perform maintenance proactively.
* **Implementation**: Sensor data from machinery is streamed into AWS Kinesis Data Streams. A real-time processing application analyzes the data for signs of wear and tear, predicting failures before they occur and scheduling maintenance to prevent downtime.

## **Enterprise Messaging Systems**

Enterprise messaging systems provide robust, scalable, and feature-rich messaging solutions for complex enterprise environments.

* [**IBM MQ**](https://www.ibm.com/products/mq): Reliable messaging middleware for enterprise systems.
* [**TIBCO EMS**](https://docs.tibco.com/pub/ems/10.3.0/doc/pdf/TIB\_ems\_10.3.0\_user\_guide.pdf?id=2) **(Enterprise Message Service)**: Enterprise messaging platform supporting JMS.
* [**Oracle Advanced Queuing**](https://docs.oracle.com/cd/B10500\_01/appdev.920/a96587/qintro.htm) **(AQ)**: Message queuing service built into Oracle Database.
* [**Apache Pulsar**](https://pulsar.apache.org/): Distributed messaging and streaming platform for high-performance use cases.

### Use Cases

**Use Case 1: Banking Transaction System**

* **Scenario**: A bank processes millions of transactions daily, ensuring consistency and reliability.
* **Implementation**: IBM MQ is used to queue and process transactions, ensuring messages are delivered reliably and in the correct order. This system guarantees transaction integrity and supports various transaction types.

**Use Case 2: Airline Reservation System**

* **Scenario**: An airline manages booking and reservation data.
* **Implementation**: TIBCO EMS (Enterprise Message Service) handles communication between different parts of the booking system, ensuring real-time updates and consistent data across all systems involved in reservations, ticketing, and customer service.

***

## **Managed Messaging Services**

Managed messaging services are provided by cloud vendors and offer ease of use, scalability, and integration with other cloud services.

* [**Amazon SQS**](https://docs.aws.amazon.com/AWSSimpleQueueService/latest/SQSDeveloperGuide/welcome.html) **and** [**SNS**](https://docs.aws.amazon.com/sns/): Managed queuing and pub/sub services.
* [**Azure Service Bus**](https://learn.microsoft.com/en-us/azure/service-bus-messaging/service-bus-messaging-overview) **and** [**Event Hubs**](https://learn.microsoft.com/en-us/azure/event-hubs/): Managed messaging and event streaming services.
* [**Google Cloud Pub/Sub**](https://cloud.google.com/pubsub/docs/overview) **and** [**Tasks**](https://cloud.google.com/tasks/docs): Managed pub/sub and task scheduling services.
* [**IBM Cloud Message Hub**](https://www.ibm.com/blog/ibm-message-hub-is-now-ibm-event-streams/): Managed Apache Kafka service.

### Use Cases

**Use Case 1: Microservices Communication**

* **Scenario**: A large-scale application with multiple microservices needs reliable communication.
* **Implementation**: Amazon SQS and SNS are used to manage messaging between microservices. SQS ensures reliable task queuing while SNS handles event notifications and pub/sub messaging, providing a robust communication framework.

**Use Case 2: E-commerce Order Fulfillment**

* **Scenario**: An e-commerce platform processes orders and updates inventory.
* **Implementation**: Azure Service Bus is used to manage messages between the order processing system and inventory management. This setup ensures reliable message delivery, order tracking, and inventory updates, providing a seamless order fulfillment process.

***

## **References**

[https://learn.microsoft.com/en-us/azure/architecture/guide/technology-choices/messaging](https://learn.microsoft.com/en-us/azure/architecture/guide/technology-choices/messaging)\
[https://cloud.google.com/tasks/docs](https://cloud.google.com/tasks/docs)\
[https://docs.aws.amazon.com/AWSSimpleQueueService/latest/SQSDeveloperGuide/welcome.html](https://docs.aws.amazon.com/AWSSimpleQueueService/latest/SQSDeveloperGuide/welcome.html)\
[https://azure.microsoft.com/en-in/products/storage/queues#Resources](https://azure.microsoft.com/en-in/products/storage/queues#Resources)\
[https://www.ibm.com/products/mq](https://www.ibm.com/products/mq)\
[https://www.rabbitmq.com/docs](https://www.rabbitmq.com/docs)\
[https://activemq.apache.org/](https://activemq.apache.org/)\
[https://docs.aws.amazon.com/sns/](https://docs.aws.amazon.com/sns/)\
[https://learn.microsoft.com/en-us/azure/service-bus-messaging/service-bus-messaging-overview](https://learn.microsoft.com/en-us/azure/service-bus-messaging/service-bus-messaging-overview)\
[https://cloud.google.com/pubsub/docs/overview](https://cloud.google.com/pubsub/docs/overview)\
[https://www.ibm.com/blog/ibm-message-hub-is-now-ibm-event-streams/](https://www.ibm.com/blog/ibm-message-hub-is-now-ibm-event-streams/)\
[https://docs.oracle.com/cd/B10500\_01/appdev.920/a96587/qintro.htm](https://docs.oracle.com/cd/B10500\_01/appdev.920/a96587/qintro.htm)\
[https://pulsar.apache.org/docs/3.3.x/](https://pulsar.apache.org/docs/3.3.x/)\
[https://docs.tibco.com/pub/ems/10.3.0/doc/pdf/TIB\_ems\_10.3.0\_user\_guide.pdf?id=2](https://docs.tibco.com/pub/ems/10.3.0/doc/pdf/TIB\_ems\_10.3.0\_user\_guide.pdf?id=2)\
[https://storm.apache.org/releases/2.6.2/index.html](https://storm.apache.org/releases/2.6.2/index.html)\
[https://nightlies.apache.org/flink/flink-docs-stable/](https://nightlies.apache.org/flink/flink-docs-stable/)\
[https://cloud.google.com/dataflow#stream-analytics](https://cloud.google.com/dataflow#stream-analytics)\
[https://docs.aws.amazon.com/streams/latest/dev/introduction.html](https://docs.aws.amazon.com/streams/latest/dev/introduction.html)\
[https://learn.microsoft.com/en-us/azure/stream-analytics/stream-analytics-stream-analytics-query-patterns](https://learn.microsoft.com/en-us/azure/stream-analytics/stream-analytics-stream-analytics-query-patterns)\
[https://kafka.apache.org/documentation/#gettingStarted](https://kafka.apache.org/documentation/#gettingStarted)\
[https://docs.aws.amazon.com/msk/latest/developerguide/getting-started.html?refid=0c835ec3-3fbf-4e72-802c-19a02d6e2337](https://docs.aws.amazon.com/msk/latest/developerguide/getting-started.html?refid=0c835ec3-3fbf-4e72-802c-19a02d6e2337)\
[https://learn.microsoft.com/en-us/azure/event-hubs/](https://learn.microsoft.com/en-us/azure/event-hubs/)\
[https://www.ibm.com/products/event-streams](https://www.ibm.com/products/event-streams)\
[https://www.redhat.com/en/resources/amq-streams-datasheet](https://www.redhat.com/en/resources/amq-streams-datasheet)\
[https://learn.microsoft.com/en-us/azure/event-grid/overview](https://learn.microsoft.com/en-us/azure/event-grid/overview)\
[https://docs.aws.amazon.com/eventbridge/latest/userguide/eb-what-is.html](https://docs.aws.amazon.com/eventbridge/latest/userguide/eb-what-is.html)\
[https://cloud.google.com/functions#documentation](https://cloud.google.com/functions#documentation)\
[https://redis.io/docs/latest/develop/interact/pubsub/](https://redis.io/docs/latest/develop/interact/pubsub/)\
[https://aws.amazon.com/lambda/resources/](https://aws.amazon.com/lambda/resources/)\
