import serviceDeclarations.RegisteredApplicationService

// -------- top-level declarations ---------
// explicit constructor call
val myAppService1 = RegisteredApplicationService()

<warning descr="Application service must not be assigned to a static final field">val myAppService2 = RegisteredApplicationService.getInstance()</warning>


// -------- companion object declarations ---------
class MyClass {

  companion object {
    // explicit constructor call
    val myAppService1 = RegisteredApplicationService()

    <warning descr="Application service must not be assigned to a static final field">val myAppService2 = RegisteredApplicationService.getInstance()</warning>
  }

}

// -------- object declarations ---------

object MyObject {
  // explicit constructor call
  val myAppService1 = RegisteredApplicationService()

  <warning descr="Application service must not be assigned to a static final field">val myAppService2 = RegisteredApplicationService.getInstance()</warning>

}