# B-Tree

## B Tree

B-tree is a special form of balanced binary search tree (BBST) designed for fast disk access or I/O operations, and it's well employed in various commercial or open source databases like MySQL, Oracle, MongoDB etc. Unlike many binary search trees, B-tree has a branching factor spanning from dozens to thousands which means a tree node can have more than two direct descendants. Before diving into the details of B-tree operations, it is important to first understand differences between disk-based data structures and memory-based ones.

## Disk-based Data Structures <a href="#disk-based-data-structures" id="disk-based-data-structures"></a>

In the present, there are two major types of secondary storage: Hard Disk Drive ([HDD](https://en.wikipedia.org/wiki/Hard\_disk\_drive)) and Solid State Drive ([SSD](https://en.wikipedia.org/wiki/Solid-state\_drive)), both of which have random access speed considerably slower than RAM. (see: [here](https://superuser.com/questions/1173675/how-much-faster-is-memory-ram-compared-to-ssd-for-random-access/1173713)). Despite of the fact that SSD is much faster than HDD in terms of access speed, costs of SSD per GB is much more than that of the HDD.

Then, the computer I/O model can be approximated as the following picture, where the secondary storage access has time is much higher than main memory and CPU:

![](https://firebasestorage.googleapis.com/v0/b/gitbook-28427.appspot.com/o/assets%2F-LQpLOTVKDY3pIvuIk2h%2F-LQpLtuWuWX31O5763zE%2F-LQpLwMZJRZkdpobo5ak%2Fb-tree.png?generation=1541714735126951\&alt=media)Figure 1. A Simplified Computer I/O Model

And since the majority of data items are not stored in the memory, it is critical to have fewer I/O access to the disk drives to save as much time as possible. The data structures in disk have to be made differently than in the main memory.

### Hard Disk Drive <a href="#hard-disk-drive" id="hard-disk-drive"></a>

A typical HDD will look like the following picture:

![](https://firebasestorage.googleapis.com/v0/b/gitbook-28427.appspot.com/o/assets%2F-LQpLOTVKDY3pIvuIk2h%2F-LQpLtuWuWX31O5763zE%2F-LQpLwMaMtdg2uBFKAnD%2Fb-tree-2.jpg?generation=1541714734421770\&alt=media)Figure 2. Hard Disk Drive Internal Look

It consists of one or many **platters** which all spin around a common **spindle**. The drive moves a magnetic **arm** to read/write data from the underlying platters using its **head**. When the platters are spinning and the head remains still, the traveling trajectory of the head makes a circle called **track**, which is further divided into multiple **sector**s with equally distributed physical spaces for data read/write.

Normally, there are three steps to access disk sectors: **seek**, **latency** and **transfer**.

1. seek: the time it takes for the **head** to move to a relevant **track**.
2. latency: the round trip time for the **platter**s to spin for a cycle under the same read/write head.
3. transfer: read/write operations on disk sectors.

The time costs ranking from high to low: **seek** > **latency** > **transfer**. And every I/O access requires physical address lookup on the disk and triggers operations of **seek** while platters are spinning and so forth. Therefore, it is essential to reduce the total number of times the disk I/O access is triggered, especially **seek** operations in between.

### Locality of Reference and pre-read <a href="#locality-of-reference-and-pre-read" id="locality-of-reference-and-pre-read"></a>

In addition to above, modern computers always pre-read data in advance rather than read by need. Even though sometimes we only read 1 byte, the system still retrieve some length of data into the memory. (see [locality of reference](https://en.wikipedia.org/wiki/Locality\_of\_reference)) The pre-read data item normally spans as a multiple of _page_ size (4k in many operating systems, as data exchange unit between disk and memory) along a relevant **sector** (which does not involve **seek**)

For a B-tree data structure, each node possesses a space of a multiple of _page_ size (computers allocate \_page\_s side by side physically) to have a one time I/O guarantee with maximal data needed. Since the B-tree has a very large branching factor, it has far smaller height than normal BBSTs such as [red-black tree](https://cs-notes.gitbook.io/algorithm-notes/outline/overview-4/balanced-search-tree/red-black-tree), which means a key search in B-tree would require traversing far fewer nodes. As a indexing data structure in disk, B-tree is highly efficient than normal BBSTs.

## Definition of B-tree <a href="#definition-of-b-tree" id="definition-of-b-tree"></a>

A B-tree T with branching factor _M_ is a **rooted tree** that has the following properties:

1. Each node _x_ has (up to) _M_ - 1 keys and stored in non-descendent order that _x_.key1 ⩽ _x_.key2 ⩽ ... ⩽ _x_.keym-1.
2. In each node, there are _M_ number of pointers to their children in between wherein each key will have a left pointer and a right pointer.
3. Keys in a node split the ranges of their children's keys: e.g. there is a pointer between two adjacent keys 3 and 7, then the child node will have keys ranging from 3 to 7 exclusively.
4. Each _leaf_ node has the same depth, which is the height of the tree.
5. Define a constant minimum degree _**d**_ (as the order of B-tree) to represent the minimum number of keys in a non-leaf node. (B-tree typically has _**d**_ at least _M/2_)

A graphical example with _M_ = 4 (ignoring data items for convenience, in real implementations there are items associated with keys):

![](https://firebasestorage.googleapis.com/v0/b/gitbook-28427.appspot.com/o/assets%2F-LQpLOTVKDY3pIvuIk2h%2F-LQpLtuWuWX31O5763zE%2F-LQpLwMc00\_96aOAMfnB%2Fb-tree-2.png?generation=1541714734525814\&alt=media)Figure 3. A B-tree Example

## B+ Tree <a href="#b-tree" id="b-tree"></a>

Imagine there are frequent _**query**_ requests sent to the database servers or file systems for specific data, some parts of indexes should stay in memory or cache to have better response time. B+ tree is more suitable than B-tree in this scenario.

In a B+ tree, all internal nodes have no data and only keys and ONLY leaves maintain all data items instead. In this way, one I/O access of a single _page_ would retrieve a node with more indexes, therefore B+ tree is more disk-friendly (loading nodes into the memory without considering of varying data object sizes). Moreover, B+ tree is a threaded tree which means all its leaf nodes are connected and better for range query (e.g. search for a date range within the data)

![Figure 4. B+ tree illustration](https://firebasestorage.googleapis.com/v0/b/gitbook-28427.appspot.com/o/assets%2F-LQpLOTVKDY3pIvuIk2h%2F-LQpLtuWuWX31O5763zE%2F-LQpLwMe6PCT8ScoBi9k%2Fb%2Btree.jpg?generation=1541714734969927\&alt=media)

## Additional References <a href="#additional-references" id="additional-references"></a>

1. MongoDB Indexes use B tree: [https://docs.mongodb.com/manual/indexes/#id2](https://docs.mongodb.com/manual/indexes/#id2)​
2. B-Tree vs Hash Table indexing in MySQL: [https://stackoverflow.com/questions/7306316/b-tree-vs-hash-table](https://stackoverflow.com/questions/7306316/b-tree-vs-hash-table)​
3. [https://cs-notes.gitbook.io/algorithm-notes/outline/overview-4/balanced-search-tree/b-tree](https://cs-notes.gitbook.io/algorithm-notes/outline/overview-4/balanced-search-tree/b-tree)
