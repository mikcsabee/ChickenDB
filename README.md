ChickenDB
=========

ChickenDB is a basic in-memory database. Basically a HashMap with some useful features.

----------


Usage
---------

####  Initialization
```java
ChickenDB<String, User> db = new ChickenDB<>();
```

####  Defining a Filter
```java
/**
 * This Filter helps to find all User with the given Status
 */
public class StatusFilter  implements IFilter<User> {
	private Status status;
	
	/**
	 * @param status The given status
	 */
	public StatusFilter(Status status) {
		this.status = status;
	}
	
	/**
	  * Validator method
      */
	@Override
	public boolean validate(User item) {
		return item.getStatus() == status;
	}

}
```

####  Searching
```java
Map<String, User> result = db.finder()
							 .filter(new StatusFilter(Status.ONLINE))
							 .filter(/* Other filter... */)
							 .result();
```

Maven
---------
Soon...