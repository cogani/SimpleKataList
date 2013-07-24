import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ListTest {
    private   OwnList ownList;
    @Before
    public void setUp() {
        ownList = new OwnList();
    }

    @Test
    public void lookingForEmptyListReturnNull() {
        assertNull(ownList.find("fred"));
    }

    @Test
    public void addingValueToEmptyListCreateNodeWithNotLinks() {
        ownList.addItem("fred");
        OwnNode foundNode = ownList.find("fred");

        assertNotNull(foundNode);
        assertNull(foundNode.getPrevNode());
        assertNull(foundNode.getNextNode());
    }

    @Test
    public void lastItemAddedIsTheNewLastOne() {
        ownList.addItem("fred");
        ownList.addItem("wilma");

        OwnNode firstLastNode = ownList.find("fred");
        OwnNode secondLastNode = ownList.find("wilma");

        assertEquals(firstLastNode.getNextNode(), secondLastNode);
        assertEquals(firstLastNode, secondLastNode.getPrevNode());
        assertNull(secondLastNode.getNextNode());
    }

    @Test
    public void obtainingListSize(){
        addFixture3Items(ownList);

        assertEquals(3, ownList.getSize());
    }

    @Test
    public void obtainingArrayValuesFromEmptyListReturnNull(){
        String[] valuesArray = ownList.toValuesArray();

        assertNull(valuesArray);
    }

    @Test
    public void obtainingArrayValues(){
        String []expectedValuesArray = {"fred", "wilma", "barney"};
        addItemsFromArray(expectedValuesArray);
        String[] valuesArray = ownList.toValuesArray();

        assertEquals(3, valuesArray.length);
        assertTrue(Arrays.equals(expectedValuesArray, valuesArray));
    }

    @Test
    public void tryingDeletingNotPresentItemReturnFalse() {
        assertFalse(ownList.deleteItem("fred"));
    }

    @Test
    public void deletingItemFromListSizeRemoveItemFromTheList() {
        ownList.addItem("fred");

        assertTrue(ownList.deleteItem("fred"));
        assertNull(ownList.find("fred"));
    }

    @Test
    public void deletingItemDecreaseBy1SizeList() {
        ownList.addItem("fred");
        ownList.addItem("wilma");

        int initialSizeList = ownList.getSize();
        ownList.deleteItem("wilma");

        assertEquals(initialSizeList - 1, ownList.getSize());
    }

    @Test
    public void deletingFirstItemFromListSize2() {
        ownList.addItem("fred");
        ownList.addItem("wilma");

        assertEquals(true, ownList.deleteItem("fred"));
        assertEquals(null, ownList.find("fred"));
    }

    @Test
    public void deletingLastItemFromListSize2UpdateTheLastOne() {
        ownList.addItem("fred");

        ownList.addItem("wilma");
        OwnNode firstLast = ownList.find("fred");

        assertTrue(ownList.deleteItem("wilma"));
        assertNull(ownList.find("wilma"));
        assertEquals(firstLast, ownList.getLastNode());

    }

    @Test
    public void deletingMiddleItemFromListSize3() {
        addFixture3Items(ownList);

        assertTrue(ownList.deleteItem("wilma"));
        assertNull(ownList.find("wilma"));
    }

    private void addFixture3Items(OwnList ownList) {
        ownList.addItem("fred");
        ownList.addItem("wilma");
        ownList.addItem("barney");
    }

    private void addItemsFromArray(String[] values) {
        for(String value:values){
            ownList.addItem(value);
        }
    }
}