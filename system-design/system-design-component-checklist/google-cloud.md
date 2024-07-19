---
cover: >-
  https://images.unsplash.com/photo-1573220606811-bb3dce8a99ba?crop=entropy&cs=srgb&fm=jpg&ixid=M3wxOTcwMjR8MHwxfHNlYXJjaHwxfHxnb29nbGUlMjBjbG91ZHxlbnwwfHx8fDE3MjA5ODQxMjF8MA&ixlib=rb-4.0.3&q=85
coverY: 0
---

# ♦️ Google Cloud

<figure><img src="../../.gitbook/assets/System Design Components Checklist - Google Cloud (1).png" alt=""><figcaption><p>Google cloud component checklist - System design </p></figcaption></figure>

**1. Client-Side Components**

* **Web Clients**: Browsers, Web applications
* **Mobile Clients**: Android, iOS applications

**2. Server-Side Components**

* **Web Servers**:
  * **Compute Engine**: Virtual machines running web servers
  * **App Engine**: Managed platform for building and hosting web applications
* **Application Servers**:
  * **Cloud Functions**: Serverless compute for event-driven workloads
  * **App Engine**: Managed platform for application services
* **Database Servers**:
  * **Cloud SQL**: Managed relational databases (MySQL, PostgreSQL, SQL Server)
  * **Cloud Spanner**: Globally distributed, horizontally scalable relational database

**3. Databases**

* **Relational Databases (SQL)**:
  * **Cloud SQL**
  * **Cloud Spanner**
* **NoSQL Databases**:
  * **Firestore**: Document database for building applications
  * **Bigtable**: NoSQL database for large analytical and operational workloads

**4. Cache**

* **In-Memory Cache**:
  * **Cloud Memorystore**: Managed Redis and Memcached
* **Content Delivery Network (CDN)**:
  * **Cloud CDN**: Content delivery network for delivering content globally

**5. Load Balancers**

* **Cloud Load Balancing**: Distribute traffic across multiple servers
  * **HTTP(S) Load Balancing**: For HTTP/HTTPS traffic
  * **TCP/UDP Load Balancing**: For non-HTTP/HTTPS traffic
  * **SSL Proxy and TCP Proxy Load Balancing**: For secure and non-secure traffic

**6. Message Queues**

* **Pub/Sub**: Asynchronous messaging and event-driven processing

**7. API Gateways**

* **API Gateway**: Securely expose APIs to external and internal consumers

**8. Microservices**

* **Google Kubernetes Engine (GKE)**: Managed Kubernetes for container orchestration
* **Cloud Run**: Serverless containers for running stateless HTTP containers

**9. Service Discovery**

* **Service Directory**: Service discovery for microservices

**10. Configuration Management**

* **Secret Manager**: Manage and access secrets securely
* **Config Connector**: Manage Google Cloud resources using Kubernetes configuration files

**11. Monitoring and Logging**

* **Cloud Monitoring**: Full-stack monitoring for applications, infrastructure, and network
* **Cloud Logging**: Fully managed service to store, search, analyze, and monitor log data
* **Error Reporting**: Real-time error tracking

**12. Authentication and Authorization**

* **Identity and Access Management (IAM)**: Manage user access and encryption keys
* **Firebase Authentication**: User authentication, authorization, and user management

**13. Scalability and Reliability**

* **Horizontal Scaling**:
  * Use **Compute Engine** instance groups for automatic scaling
  * **App Engine** auto-scaling for web apps
* **Vertical Scaling**:
  * Increase the resources of individual Compute Engine instances
* **Redundancy**:
  * Use **Multi-Regional Storage** and **Cloud Load Balancing** for redundancy
* **Backup and Disaster Recovery**:
  * **Cloud Storage** and **Cloud SQL** backups for data integrity and availability

**14. Networking**

* **Cloud DNS**: Scalable, reliable, and managed authoritative DNS service
* **Virtual Private Cloud (VPC)**: Private network within Google Cloud
* **Cloud Firewall**: Managed firewall service

**15. DevOps and CI/CD**

* **Cloud Build**: Continuous integration and delivery
* **Artifact Registry**: Store, manage, and secure your build artifacts
* **Cloud Source Repositories**: Source control service

**16. Data Processing**

* **Batch Processing**:
  * **Dataflow**: Stream and batch processing using Apache Beam
* **Stream Processing**:
  * **Pub/Sub**: Real-time messaging
  * **Dataflow**: Real-time data processing

**17. Analytics and Reporting**

* **BigQuery**: Serverless, highly scalable, and cost-effective multi-cloud data warehouse
* **Looker**: Business intelligence and analytics platform
* **Data Studio**: Dashboarding and reporting tool
