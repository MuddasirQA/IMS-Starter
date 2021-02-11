Coverage: 68.4%
# Muddasir's IMS project

This project is coded in Java and can either connect through JDBC to a local mySQL instance or by using GCP. The project consists of four main functions, Create, Read, Update, and Delete (CRUD). The inventory management system contains a list of customers, items and orders. A customer creates an order and adds/removes items in an order by using the CRUD functionalities. The end-user can also generate new customers and items in databases

## Using the application

The interface will ask the user (you) what entity you would like to use. There are 4 options.
Customer
Item
Order
STOP

For the options of customer, item, and order, there are 4 main functions the application can perform. These are as follows.

CREATE: this creates a new customer, item or order, depending on the choice the user selecting in the previous menu. 
If the end-user selected CUSTOMER previously, then the console will ask for a first name, which the user will write into the command-line, and then a surname. The Customer is then created.

READ: This will read all entries in the database for a particular table. The read function will vary depending on which entitiy was selecting in the first menu. 
if the end-user selected orders > read, the console will print out all orders, with their order id, customer id, and the items within each order listed below each order respectively.

UPDATE: This function will change an existing database entry, for example, if the user selected ITEMS and then UPDATE, the user will be prompted to enter the item ID they wish to update, followed by the new item name, and new item price for this particular ID.

DELETE: This function will ask for an ID, (customer, order, or item), that the end-user must input. The ID that is selected will be removed from the database along with all other values for that entry.



### Installing

A step by step series of examples that tell you how to get a development env running

Say what the step will be

```
Give the example
```

And repeat

```
until finished
```

End with an example of getting some data out of the system or using it for a little demo

## Running the tests

Explain how to run the automated tests for this system. Break down into which tests and what they do

### Unit Tests 

JUNIT tests are used in this project to test each method that is used within the application. Each test case will verify if the intented outcome is equal to the actual outcome using assertEquals(param1,param2). Mockito is also used in these unit tests to determine how many times a method is executed.

```
Give an example
```

### Integration Tests 
Explain what these tests test, why and how to run them

```
Give an example
```

### And coding style tests

Explain what these tests test and why

```
Give an example
```

## Deployment

Add additional notes about how to deploy this on a live system

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

We use [SemVer](http://semver.org/) for versioning.

## Authors

Muddasir Ahmad (https://github.com/MuddasirQA)

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

## Acknowledgments

* Thanks to the original author who created the base-line version of this application.
