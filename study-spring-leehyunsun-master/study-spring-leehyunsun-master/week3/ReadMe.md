**의존: 상속 or composition(필드값으로 가지는 것)**

**DI, AOP, IOC**
AOP: 중복은 피하려고 만든 것. 

DI: 스프링이 대신 객체를 만들어 주는 것

IOC: 스프링 컨테이너가 의존성을 대신 제어해 주는 것.

싱글톤 패턴: 멤버서비스를 다른 서비스가 가지고 오는 게 어려움(멤버 서비스 쓰면 스택에서 사라져버리므로)->컴포넌트를 엄청 많이 생성해야하는  문제점이 생김->의존을 이용하여 하나만 가져와서 관리하면 되는데, 이를 스프링이 해줌

controller: 클라이언트 요청을 받고, 일 처리하는 애들한테 보내서, 그 결과를 받아서 다시 클라이언트에게 주는 것 -> 클라이언트와 상호작용. 무거운 테스크를 맡기면 안 된다. service를 의존
service: transaction을 보장(순서를 보장. 동시에 요청이 들어왔을 때 어떤 것을 먼저 처리할 지에 관한 처리) repository에  db에 대한 요청을 처리하는 것.  repository를 의존

repository: DB에 들어가서 자료를 요청

bean:규칙이 있는 문서. bean으로 규칙을 만들어줌. 

spring bean: bean 중에서 스프링 컨테이너와 관련이 있는 것

스프링 컨테이너: 의존성 주입되는 애들을 관리하는 것. 
