# quarkus-jsonbexception
Quarkus hibernate orm and panache throwing JsonBException

This is an example where Quarkus Hibernate ORM and JPA and Quarkus Hibernate ORM with Panache is throwing a JsonbException 
when an Entity has a Many-One and One-Many relationship with itself.

```
Internal Server Error
Error handling 7ec26d8c-f938-43a2-830c-b171e7952cf5-1, 
org.jboss.resteasy.spi.UnhandledException: javax.ws.rs.ProcessingException: 
RESTEASY008205: JSON Binding serialization error javax.json.bind.JsonbException: 
Unable to serialize property 'children' from me.louwrens.quarkus.hibernate.Category

javax.json.bind.JsonbException: Recursive reference has been found in class class me.louwrens.quarkus.hibernate.Category.
	at org.eclipse.yasson.internal.serializer.ObjectSerializer.serializeInternal(ObjectSerializer.java:76)
	at org.eclipse.yasson.internal.serializer.AbstractContainerSerializer.serialize(AbstractContainerSerializer.java:107)
	at org.eclipse.yasson.internal.serializer.AbstractContainerSerializer.serializerCaptor(AbstractContainerSerializer.java:125)
	at org.eclipse.yasson.internal.serializer.ObjectSerializer.marshallProperty(ObjectSerializer.java:121)
	at org.eclipse.yasson.internal.serializer.ObjectSerializer.serializeInternal(ObjectSerializer.java:69)
```
I have added a Spring Boot application where the recursive reference problem is solved by using `@JsonIdentityInfo`.

However the same solution is not working for Quarkus.
