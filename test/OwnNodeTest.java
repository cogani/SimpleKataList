import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OwnNodeTest {
    @Test
    public void creatingNodeWithValue() throws Exception{
        OwnNode ownNode = new OwnNode("Fred");
        assertEquals("Fred", ownNode.getValue());
    }
}
