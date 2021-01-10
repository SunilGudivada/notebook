# Programming Language and Fundementals

## OOP & Design patterns

Priority: P2

In their pure form, such questions are not very common now. It is unlikely that you will be asked what is encapsulation, polymorphism, or inheritance. However, such questions may  
 meet as accompanying systems design. For example, if you are asked to design  
 a class diagram or data entities for a system, you may be asked why you chose not inheritance, but aggregation \(composition\). Or vice versa. And what are you at all prefer. And why do you prefer this. Is this due to the characteristics of your programming language \(for example, java eliminates multiple inheritance\)? Something else? What exactly?

### Recommended to know

* **Singleton**. The most famous pattern, which, nevertheless, has not been canceled. Where

  occurs in real life, that is, in live code.

* **Active Record.** Chain of Responsibility. Data Transfer Object. Adapter. Decorator. Factory. Factory Method. Other standard programming patterns.
* **Data design**. In case of relational data - table for class, table for all classes, table for

  each concrete class, what and why. Relational databases still have a very significant a place.  

### Books

* [Patterns of Enterprise Application Architecture by Martin Fowler](https://amzn.com/B008OHVDFM)

## Programming language of choice 

The programming language is your working tool. And from you, as a professional, it is expected that you will not only know the limited set of functionality that you use every day, but also more deeply understand your language. And if a beginner can be forgiven lack of deep understanding, for example, Java garbage collection, then the person who writes on Java is unlikely for many years. Even if at work he does not encounter him \(which is usually true, because everything works like that, is there any point in delving deeply?\), then this creates the impression of a person who is interested in and has no enthusiasm for his profession. This is not the impression that you want to produce for an employer.

It is worth considering that questions from this part will most likely start asking you if you have 5+ years of solid experience in this particular language. You will be expected that since you are on it so you write a lot, you should know good ins & outs.

If you have 1-2 years of experience, you recently graduated from university and have been writing all this time, say, in Java, then don't worry too much about the intricacies. Just make sure you understand well the basics and principles of your language.

### What you need to know

* Best practices of your language. Be sure to check out Effective Java or Effective C ++, if this your languages. Google "best practices ", I'm sure you'll find enough good stuff.
* Worst practices of your language. For example things that will work but will work slowly, or crookedly, or at the risk of collapsing at the first opportunity. If you google "C ++ avoid" or "C ++ pitfalls", then a lot of different interesting things will come out \([for example](http://stackoverflow.com/questions/30373/what-c-pitfalls-should-i-avoid)\).
* Features of your language - does it have a garbage collector, how does it work with memory, as in it implements virtual functions, which makes it globally different from other languages programming, in what situations is your language better than others and why?
* How to do various useful things in your programming language, if possible. For example an immutable class, or a class that cannot be copied.
* Working with memory. Stack vs heap. malloc vs new \(for C ++\).

### Advice

* Read [Google style](https://github.com/google/styleguide) guide for your programming language. There is a lot of useful information.
* Read at least one book about your programming language \("Effective X" will do\).
* Search for puzzles about your programming language. When a small program is written and the reader is required to understand what the program will produce. For example, for [C ++](http://cppquiz.org/quiz/question/8)... Googles on "[C ++ quiz](http://cppquiz.org/quiz/question/8) ". [For Java](http://www.javapuzzlers.com/).

## General Outlook

Most of the things listed in this chapter you need to know on a general level - have a good presentation, but not necessarily deeply into the details. Be able to respond to basic questions like "So I wrote a program in C ++, what happens next?" Here you need to understand about compilers, and about machine code, and about processor instructions.

The exception is if you have been working with any of these areas for a long time. In this case more solid knowledge will be expected from you.

### What you need to know

* That in reality things do not work quite the way they do in theory. For example, if you want store in memory HashMap, then you store not only the values, but also the data structure itself. This is called overhead. This is usually one or two additional pointers for a node. If there are a lot of values, and they are all, for example, numbers, then the overhead may appear quite substantial.
* Databases. NoSQL vs RDBMS \(relational databases\), what is index, what is key and attribute.
* Regular expressions and automata / grammars.
* Computer architecture - memory, processors, registers, buses, disk, instructions
* Operating systems - what is a thread and a process \(and how do they differ\), what are in the OS components, how the processor interacts with memory, where the operating system is from loaded when the computer is turned on, etc.
* Networks and how the Internet works.
* Compilers in general terms.
* Data storage, RAID.
* Computer security, cryptography.

### Books

* Books by Andrew Tanenbaum. They are big, but very well written. So read quickly for general development.
* [List of books](http://stackoverflow.com/questions/1711/what-is-the-single-most-influential-book-every-programmer-should-read), according to Stackoverflow contributors that every good one should read programmer. The list is huge, you should not read every book from there, but you can considered as a manual for the selection of good books.
* [Recommended reading from the Google ](https://translate.google.com/translate?hl=en&prev=_t&sl=ru&tl=en&u=http://larrr.com/rekomenduemaya-literatura-ot-google/)- the Google allowed the publication of a list of references, which we recommend employees to read.

### Links and Articles

* ["for What every major computer science TM Should the know"](http://matt.might.net/articles/what-cs-majors-should-know/) . A very long list, don't take verbatim. But there are good links to materials.
* ["the Programmer Competency the Matrix"](http://www.starling-software.com/employment/programmer-competency-matrix.html) - a huge list of knowledge, divided by levels. 
* "[What should every programmer know about X](https://www.quora.com/topic/What-Should-Every-Programmer-Know-About-X)"... A series of articles on Quora on a variety of topics. 
* " [Latency numbers every programmer Should the know](https://gist.github.com/jboner/2841832)" 
* [The the Hardware / Software Interface \(University then of Washington You\) -](https://www.coursetalk.com/providers/coursera/courses/the-hardwaresoftware-interface) a course on computer architecture

