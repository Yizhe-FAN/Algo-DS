package basic;

import java.util.ArrayList;
import java.util.List;

class GenericTest {
    List<Object> locObjectList = new ArrayList<>();
    List<FakeChild> locChildList = new ArrayList<>();
    List<FakeParent> locParentList = new ArrayList<>();
    List<? extends FakeParent> locGenericList = new ArrayList<>();


    public final void test(){
        locObjectList.add(new FakeChild());
        locChildList.add(new FakeChild());
        locParentList.add(new FakeParent());
        locParentList.add(new FakeChild());
        // can not add element
        // locGenericParentList.add(new FakeParentClass());
        // locGenericParentList.add(new FakeChildClass());


        // testParam(locChildList);
        testParam(locObjectList);

        //testClassParam(locObjectList);
        testClassParam(locParentList);
        //testClassParam(locChildList);

        testGenericParam(locObjectList);
        testGenericParam(locChildList);
        testGenericParam(locParentList);

        testGenericDownParam(locChildList);
        testGenericDownParam(locParentList);
        // testGenericDownParam(locObjectList);

        testGenericTopParam(locParentList);
        testGenericTopParam(locObjectList); // ??
        // testGenericTopParam(locChildList); // limit higher class

        // testParam(locGenericList);
        // testClassParam(locGenericList);
        testGenericParam(locGenericList);
        // testGenericTopParam(locGenericList);
        testGenericDownParam(locGenericList);
    }

    public final void testParam(List<Object> parList) {

    }

    public final void testClassParam(List<FakeParent> parParentList) {
        FakeParent locP = parParentList.get(0);
        FakeGrandpa locG = parParentList.get(0);
        // FakeChild locC = parParentList.get(0);
        parParentList.add(new FakeChild());
    }

    public final void testGenericParam(List<? extends Object> parGenericClassList) {
        // parGenericClassList.add(new FakeChildClass());
    }

    public final void testGenericDownParam(List<? extends FakeParent> parGenericClassList) {
        // parGenericClassList.add(new FakeParentClass());
        // parGenericClassList.add(new FakeChildClass());
        FakeParent locP = parGenericClassList.get(0);
        FakeGrandpa locG = parGenericClassList.get(0);
        parGenericClassList.remove(0);
    }

    public final void testGenericTopParam(List<? super FakeParent> parGenericClassList) {
        parGenericClassList.add(new FakeChild());
        parGenericClassList.add(new FakeParent());
        // FakeParent locP = parGenericClassList.get(0);
    }

}

class FakeGrandpa {
}

class FakeParent extends FakeGrandpa {
}

class FakeChild extends FakeParent {
}
