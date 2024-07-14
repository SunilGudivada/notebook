---
cover: >-
  https://images.unsplash.com/photo-1591270551371-3401a1a9382f?crop=entropy&cs=srgb&fm=jpg&ixid=M3wxOTcwMjR8MHwxfHNlYXJjaHw2fHxhbWF6b258ZW58MHx8fHwxNzIwOTg0MTAwfDA&ixlib=rb-4.0.3&q=85
coverY: 0
---

# AWS

<figure><img src="../../.gitbook/assets/System Design Components Checklist - AWS (1).png" alt=""><figcaption><p>AWS Component checklist - System Design</p></figcaption></figure>

**1. Client-Side Components**

* **Web Clients**: Browsers, Web applications
* **Mobile Clients**: Android, iOS applications

**2. Server-Side Components**

* **Web Servers**:
  * **Amazon EC2**: Virtual servers for running web applications
  * **AWS Elastic Beanstalk**: Deploy and manage applications
* **Application Servers**:
  * **AWS Lambda**: Serverless compute for event-driven workloads
  * **Amazon EC2**: General-purpose compute
* **Database Servers**:
  * **Amazon RDS**: Managed relational databases (MySQL, PostgreSQL, etc.)
  * **Amazon Aurora**: High-performance, fully managed relational database

**3. Databases**

* **Relational Databases (SQL)**:
  * **Amazon RDS**: MySQL, PostgreSQL, Oracle, SQL Server
  * **Amazon Aurora**
* **NoSQL Databases**:
  * **Amazon DynamoDB**
  * **Amazon DocumentDB** (with MongoDB compatibility)

**4. Cache**

* **In-Memory Cache**:
  * **Amazon ElastiCache**: Redis, Memcached
* **Content Delivery Network (CDN)**:
  * **Amazon CloudFront**

**5. Load Balancers**

* **Elastic Load Balancing (ELB)**: Distribute traffic across multiple servers
  * **Application Load Balancer (ALB)**: For HTTP/HTTPS traffic
  * **Network Load Balancer (NLB)**: For TCP/UDP traffic
  * **Classic Load Balancer (CLB)**: Legacy applications

**6. Message Queues**

* **Amazon SQS**: Simple Queue Service for reliable messaging
* **Amazon SNS**: Simple Notification Service for pub/sub messaging

**7. API Gateways**

* **Amazon API Gateway**: Securely expose APIs to external and internal consumers

**8. Microservices**

* **Amazon ECS**: Elastic Container Service for containerized applications
* **Amazon EKS**: Elastic Kubernetes Service for Kubernetes orchestration
* **AWS Fargate**: Serverless compute for containers

**9. Service Discovery**

* **AWS Cloud Map**: Service discovery for microservices
* **Amazon ECS Service Discovery**: Native service discovery for ECS

**10. Configuration Management**

* **AWS Systems Manager Parameter Store**: Centralized management of configuration settings
* **AWS Secrets Manager**: Manage and retrieve secrets

**11. Monitoring and Logging**

* **Amazon CloudWatch**: Full-stack monitoring for applications, infrastructure, and network
* **AWS CloudTrail**: Logging of AWS API calls
* **Amazon Elasticsearch Service (Amazon OpenSearch Service)**: Analyze and visualize log data

**12. Authentication and Authorization**

* **AWS IAM (Identity and Access Management)**: Manage user access and encryption keys
* **Amazon Cognito**: User authentication, authorization, and user management

**13. Scalability and Reliability**

* **Horizontal Scaling**:
  * Use **Amazon EC2 Auto Scaling** for automatic scaling of EC2 instances
* **Vertical Scaling**:
  * Increase resources of individual Amazon EC2 instances
* **Redundancy**:
  * Use **AWS Availability Zones** and **AWS Regions** for redundancy
* **Backup and Disaster Recovery**:
  * **AWS Backup** and **Amazon S3** for data integrity and availability

**14. Networking**

* **Amazon Route 53**: Domain name resolution
* **AWS Firewall Manager**: Manage firewall rules across accounts
* **Amazon VPC (Virtual Private Cloud)**: Private network within AWS

**15. DevOps and CI/CD**

* **AWS CodePipeline**: Continuous delivery service
* **AWS CodeBuild**: Build and test code
* **AWS CodeDeploy**: Automated deployment to EC2, Lambda, and on-premises servers
* **AWS CodeCommit**: Source control service

**16. Data Processing**

* **Batch Processing**:
  * **AWS Batch**: Run batch computing workloads
* **Stream Processing**:
  * **Amazon Kinesis**: Real-time data streaming and analytics
  * **AWS Lambda**: For processing data streams in real-time

**17. Analytics and Reporting**

* **Amazon Redshift**: Data warehousing
* **Amazon QuickSight**: Business analytics service
* **AWS Glue**: ETL (Extract, Transform, Load) service for data integration
