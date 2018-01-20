# d2d-cafe
####How to run

There is a simple demo Application Runner which simulates a point of sale transaction
inside the test folder package `au.net.woodberry.d2d.cafe`

The `CafeDemo.java` runner will run a sample point of sale transaction and output a response

    Preparing order...
    --------
    Item            : House blend
    Preparation     : Mocha
    Size            : Standard
    Optional Extras : [Milk, Sugar, Coco powder]
    --------
    Total cost      : 4.35
####Key Design Points

* The solution is kept purposely simple - No 3rd party libraries were ultimately required on the mainline.
* The point of sale solution from a backend perspective is an `OrderService` that accepts any type of `MenuItem`. 
* The `Service`, `Domain` and `Repository` do not understand the concept of a Coffee. This context is only 
  evident in `RepositoryData`. This allows for higher order abstractions, for example another type
  of beverage could be introduced quite easily.
* Conceptually, `MenuItem` is denoted by items with a ($), `MenuItemPreparation`, `MenuItemExtra` are denoted by (+) and `MenuItemSize` is denoted by (x).

For Example:

| MenuItem ($) | MenuItemPreparation (+) | MenuItemExtra (+) | MenuItemSize (x) |
|:---:|:---:|:---:|:---:|
| Dark roast ($1) | Latte (+ $1.00)| Sugar (+ $0.25) | Large (x1.5) |

####Quality control
* All unit tests are located in `OrderServiceImplTest`.
* This test class uses Mockito's `@Spy` annotation instead of `@Mock`. Normally, there would be unit tests for 
  the repository layer but as the repositories themselves are essentially mocked through the use of static data, 
  there isn't much value in creating unit tests.
  The use of spies on the repository classes will still allow for verification and correctness of the service in interacting with the repository.