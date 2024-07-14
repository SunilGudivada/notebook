---
cover: >-
  https://images.unsplash.com/photo-1611083616600-d3fdc4198aa6?crop=entropy&cs=srgb&fm=jpg&ixid=M3wxOTcwMjR8MHwxfHNlYXJjaHwxfHxBenVyZXxlbnwwfHx8fDE3MjA5ODQwNTh8MA&ixlib=rb-4.0.3&q=85
coverY: 0
---

# Azure

<figure><img src="../../.gitbook/assets/System Design Components Checklist - Azure (1).png" alt=""><figcaption><p>Azure Component Checklist in system design - Study Sheet</p></figcaption></figure>

**1. Client-Side Components**

* **Web Clients**: Browsers, Web applications
* **Mobile Clients**: Android, iOS applications

**2. Server-Side Components**

* **Web Servers**:
  * **Azure App Service**: Host web applications, RESTful APIs
* **Application Servers**:
  * **Azure Functions**: Serverless compute for event-driven workloads
  * **Azure App Service**: Host application services
* **Database Servers**:
  * **Azure SQL Database**: Managed relational SQL database
  * **Azure Cosmos DB**: Globally distributed NoSQL database

**3. Databases**

* **Relational Databases (SQL)**:
  * **Azure SQL Database**
  * **Azure Database for MySQL/PostgreSQL**
* **NoSQL Databases**:
  * **Azure Cosmos DB**
  * **Azure Table Storage**

**4. Cache**

* **In-Memory Cache**:
  * **Azure Cache for Redis**
* **Content Delivery Network (CDN)**:
  * **Azure CDN**

**5. Load Balancers**

* **Azure Load Balancer**: Distribute traffic across multiple servers
* **Azure Application Gateway**: Load balancing with application-level routing and SSL termination

**6. Message Queues**

* **Azure Service Bus**: Enterprise messaging for reliable messaging
* **Azure Queue Storage**: Simple message queuing for large workloads

**7. API Gateways**

* **Azure API Management**: Securely expose APIs to external and internal consumers

**8. Microservices**

* **Azure Kubernetes Service (AKS)**: Deploy and manage containerized applications
* **Azure Service Fabric**: Platform for microservices and container orchestration

**9. Service Discovery**

* **Azure Service Fabric**: Built-in service discovery for microservices
* **Azure Kubernetes Service (AKS)**: Use Kubernetes-native service discovery

**10. Configuration Management**

* **Azure App Configuration**: Centralized management of application settings

**11. Monitoring and Logging**

* **Azure Monitor**: Full-stack monitoring for applications, infrastructure, and network
* **Azure Log Analytics**: Collect and analyze log data from various sources
* **Azure Application Insights**: Monitor live applications and diagnose issues

**12. Authentication and Authorization**

* **Azure Active Directory (Azure AD)**: Identity and access management
* **Azure AD B2C**: Identity management for consumer-facing applications

**13. Scalability and Reliability**

* **Horizontal Scaling**:
  * Use **Azure Virtual Machine Scale Sets** for VM-based applications
  * **Azure App Service** auto-scaling for web apps
* **Vertical Scaling**:
  * Increase the resources of individual Azure VMs or services
* **Redundancy**:
  * Use **Azure Availability Zones** and **Azure Regions** for redundancy
* **Backup and Disaster Recovery**:
  * **Azure Backup** and **Azure Site Recovery** for data integrity and availability

**14. Networking**

* **Azure DNS**: Domain name resolution
* **Azure Firewall**: Network security
* **Azure Virtual Network (VNet)**: Private network within Azure

**15. DevOps and CI/CD**

* **Azure DevOps**: Complete CI/CD pipeline, repositories, and project management
* **GitHub Actions for Azure**: CI/CD workflows with GitHub integration

**16. Data Processing**

* **Batch Processing**:
  * **Azure Batch**: Large-scale parallel and high-performance computing
* **Stream Processing**:
  * **Azure Stream Analytics**: Real-time data processing
  * **Azure Event Hubs**: Data streaming platform

**17. Analytics and Reporting**

* **Azure Synapse Analytics**: Integrated analytics service for big data and data warehousing
*
