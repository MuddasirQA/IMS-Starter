Coverage: 68.4%
# Muddasir's IMS project



## Introduction

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

The source code for this project can be downloaded or forked (github.com/MuddasirQA/IMS-Starter) from this repository.

This project connects to a database (JDBC), please ensure that the connection is made with the correct credentials, which can be found within the db.properties file, alternatively you can request this information from Muddasir.

You will need to install jdk 14.0.2 and set up a system environment variable with the correct directory appended to PATH to run java commands in your terminal. More information on how to do this can be found on QA community.

Whilst in the target folder of the project, open a terminal (Git bash here) and run the command 

java -jar IMS-0.0.1-jar-with-dependencies

Please see "Using the application" at the top of this readme file for an extensive breakdown on how to use this application.



Tests cases are created for the DAO, domain, and Controller aspects of the application.

### Unit Tests 

JUNIT tests are used in this project to test each method that is used within the application. Each test case will verify if the intented outcome is equal to the actual outcome using assertEquals(param1,param2). Mockito is also used in these unit tests to determine how many times a method is executed.

```
@RunWith(MockitoJUnitRunner.class)
public class ItemsControllerTest {
	@Mock
	private Utils utils;

	@Mock
	private ItemsDAO dao;

	@InjectMocks
	private ItemsController controller;

	@Test
	public void testCreate() {
		final String itemName = "book1";
		final Double itemPrice = 10.00d;

		final Items created = new Items(itemName, itemPrice);

		Mockito.when(utils.getString()).thenReturn(itemName);
		Mockito.when(utils.getDouble()).thenReturn(itemPrice);
		Mockito.when(dao.create(created)).thenReturn(created);

		assertEquals(created, controller.create());

		Mockito.verify(utils, Mockito.times(1)).getString();
		Mockito.verify(utils, Mockito.times(1)).getDouble();

		Mockito.verify(dao, Mockito.times(1)).create(created);
	}
  }
```



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

* Thanks to the original author(s) who created the base-line version of this application
Thanks to JHarry444 for the READ.ME template.

