# 🧑‍🤝‍🧑 Designing Instagram's Collaborative Content Creation - Close Friends Only

No need of introduction on what is instagram ? But needs introduction for **Close Friends only** feature.

Designing Instagram's '**Close Friends Only**' feature involves creating a system where users can make a list of close friends. When they share content, the system checks this list to ensure only those friends can see it. This requires quick data access and strong security measures to keep the shared content private and secure.



This feature is now available across the streaming platforms like **Spotify, Youtube, IHeartRadios and apple podcasts.**

During the interview, please follow the below steps:

* Understand the Problem
* Define the Scope and Requirements
* Envelope Calculations
* High-Level System Design
* Component Design
* Scalability and Reliability
* Security Considerations
* Monitoring and Maintenance
* Trade-offs and Considerations

{% content-ref url="step-by-step-guide.md" %}
[step-by-step-guide.md](step-by-step-guide.md)
{% endcontent-ref %}

## Scope and Requirements

### **Functional Requirements**:

* Users can add or remove friends from their close friends list.
* Users can share content visible only to close friends.
* Close friends receive notifications for shared content.

### **Non-Functional Requirements**:

* Low-latency access to close friends list.
* High availability and reliability.
* Secure data transmission and storage

## Envelope Calculations

As of 2024 by statista there are 2 Billion users in the instagram. People spend lot of time in instagram assume 60% (1.2 Billion ) of the users active and  also considering 50 average users in the close friends list.&#x20;

Not all the users list will be active all the time assume 20% of active users (240 million users). Considering 10% of the users posted i.e (24 million posts/day).

Lets understand the storage requirements.&#x20;

### Storage requirements

Consider 1KB of each user profile data (including user ID, name, profile picture URL, etc.) so for 2 Billion users we need atleast 2 Billion \* 1 KB which is around 2 TB.

Lets do storage requirement for close friends, store only user Id ( 20 Bytes ), for one user needs around 50 \* 20 B = 1 KB.

for  2 Billion users we need 2 B \* 1KB = 2 TB



Now lets do media storage requirement, Assume these are the content ( photo - 1 MB , Video - 10 MB, Story - 5 MB ). Lets do some content distribution - Photos 70%, Videos 20%, story 10%.

**Photos**:

Posts/day: 24 million \* 70% = 16.8 million

Storage/day: 16.8 million \* 1 MB = 16.8 TB/day

Annual storage: 16.8 TB/day \* 365 days = 6132 TB = \~6.1 PB/year

**Videos**:

Posts/day: 24 million \* 20% = 4.8 million

Storage/day: 4.8 million \* 10 MB = 48 TB/day

Annual storage: 48 TB/day \* 365 days = 17520 TB = \~17.5 PB/year

**Stories**:

Posts/day: 24 million \* 10% = 2.4 million

Storage/day: 2.4 million \* 5 MB = 12 TB/day

Annual storage: 12 TB/day \* 365 days = 4380 TB = \~4.4 PB/year

Total storage requried - 6.1 PB + 17.5 PB + 4.4 PB = 28 PB / Year



Considering the social media platform like instagram, bandwith calculations are important. Assume 50 Views per post.&#x20;

We should consider upload and download bandwidth

**Upload:**

Photos: 16.8 million \* 1 MB = 16.8 TB

Videos: 4.8 million \* 10 MB = 48 TB

Stories: 2.4 million \* 5 MB = 12 TB

Total Daily Upload: 16.8 + 48 + 12 = 76.8 TB/day



**Download:**&#x20;

**Daily Views**:

Photos: 16.8 million \* 50 = 840 million

Videos: 4.8 million \* 50 = 240 million

Stories: 2.4 million \* 50 = 120 million



**Daily Download Volume**:

Photos: 840 million \* 1 MB = 840 TB

Videos: 240 million \* 10 MB = 2400 TB

Stories: 120 million \* 5 MB = 600 TB



**Total Daily Download**: 840 + 2400 + 600 = 3840 TB/day = 3.84 PB/day

**Total Bandwidth:** 3.92 PB / day

## High Level System design

List of microservices required for this feature

**Microservices:**&#x20;

* User Service
* Close Friends Service
* Content Service
* Access Control Service
* Notification Service
* Frontend Service

## Component Design

Microservices, Load Balancer, Storage, Caching

For user management - Relational DB - MySQL Database

For Close Friends - Relation DB - MySQL Database

For Content Sharing - Front end communicating to the content service.

Content Metadata will be stored in NoSQL and files in the distributed storage and content will be served via CDN.&#x20;

For Notifications, notifications service will be communicated with kafka to listen the content sharing activities. and notifications will be shared only to close friends.

Studio Link:&#x20;

<figure><img src="../.gitbook/assets/instagram-close-friends-system-design.gif" alt=""><figcaption></figcaption></figure>

## Scalability and Reliability

**Load Balancers**: Distribute requests across multiple servers.

**Database Sharding**: Split databases to handle high traffic.

**Caching**: Use Redis for quick access to frequently accessed data.

**CDN**: Deliver media content quickly and reliably.

## Security Considerations

Encryption is very important considering the videos and photos shared only to group of users. Encrypt the data in transit using TLS. TLS, is a widely adopted security protocol designed to facilitate privacy and data security for communications over the Internet.&#x20;

Coming to the access control, Strict checks to ensure only authorized users access content. Considering the security modifications to access need to be audited for compliance requirements.&#x20;

## Monitoring and Maintenance

Collecting logs for monitoring system health and debugging. Monitor key performance indicators such as latency, error rates, and throughput. Setting up alerts for unusual activity or performance degradation.

## Trade-offs and Considerations

Considering the feature like close friends only, below trade off are worth to discuss.&#x20;

**Performance VS Security**: Balancing quick access with strong security measures.

**Consistency VS Availability**: Using eventual consistency for high availability.

**Storage Costs**: Managing the cost of storing large amounts of media content.



## References

[https://about.instagram.com/blog/announcements/renee-rapp-rachel-sennott-on-close-friends-feature](https://about.instagram.com/blog/announcements/renee-rapp-rachel-sennott-on-close-friends-feature)\
[https://www.statista.com/topics/1882/instagram/](https://www.statista.com/topics/1882/instagram/)\
[https://www.cloudflare.com/learning/ssl/transport-layer-security-tls/](https://www.cloudflare.com/learning/ssl/transport-layer-security-tls/)\
