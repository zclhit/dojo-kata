# dojo-kata

> Practice for AEP Bootcamp

AEPB，全称Agile Engineering Practice Bootcamp，主要聚焦在敏捷工程实践领域，提升团队成员的核心敏捷工程实践的落地能力，涵盖：TDD、Refactoring、Simple Design、Pair Programming、OOD、Code Review。

设计到的内容：

 **Tasking:**

tasking可以称之为任务分解，在敏捷流程开发过程中，任务分解往往是流程的第一环，也是不可或缺的一环。通过tasking有助于让我们在开发前就想清楚需求究竟是什么样的，完成了哪些AC才算通过需求，需求的边界条件。通过纵切的tasking可以帮我们制定实现这个需求的N步走计划，每一步存在的潜在风险和完成的难易程度。通过tasking可以帮助我们提前识别开发过程中的一些”坑“，同时帮助我们合理评估自己完成某项任务所需要的步骤以及每个步骤需要消耗的时间，也就是帮助我们更好的完成敏捷开发过程中的”估点“操作。



**Pair Programming:**

中文译为“结对编程”，信与不信，结对编程在现在的大多数公司和个人看来还是一个很fancy的概念，好的结对编程能够实现1+1 > 2的效果，坏的结对编程不仅浪费了大家的时间和劳动力，甚至会造成同事之间的不解与隔阂。



**OOD:**

面向对象的编程方法，单一职责，开放封闭，李氏代换，依赖倒转，接口隔离与迪米特法则。



这个仓库中的代码是按照以下任务来进行迭代和TDD的：

1. Parking lot：设计一个具有停车功能的停车场
2. Parking boy: 停车小弟
3. Smart Parking Boy：聪明的停车小弟
4. Super Parking Boy: 超级停车小弟
5. Parking Manager: 停车经理人



以下是我的Tasking的过程：

针对Parking lot:

As userA, I want to see when customer with vehicle plate number xx come our parking log

1. Given customer with plate number, and parking lot have free position, when he come to parking, should park success and return token.
2. Given customer with a right token, and this token marked car has parked in lot, when he ask to retrieve car, should retrieve car success.
3. Given customer without plate number, when he ask to park, should not park success.
4. Given customer with plate number, parking lot has not position for park, when he come to parking, should not park success.
5. Given customer with wrong token, when he asked to retrieve car, should not retrieve success.
6. Given customer without token, when he asked to retrieve car, should not retrieve success.
7. Given customer with token, but this token belongs to car has been retrieve, when he asked to retrieve car, should not retrieve success.
8. 用户A存了车1，用户B存了车2，用户A来取车，应该取回车1。



针对Parking Boy:

1. Deparct: p1有空余停车车位来车可以停在p1,返回凭证(停车场编号和取车码)
2. p1满了，来车停p2，返回凭证
3. p1 p2满，无法停车
4. 无效凭证取车，返回异常
5. 凭证取车，返回正确的车



针对Smart Parking Boy:

1. p1空位多，停p1
2. p2空位多，停p2
3. p1和p2都有位置，空位一样多，停p1



针对super pakring Boy:

针对Parking Manager:

上面两个后续补充。。。
