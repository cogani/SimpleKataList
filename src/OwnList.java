public class OwnList {
    private OwnNode firstNode = null;
    private OwnNode lastNode = null;
    private int size;

    public OwnNode find(String value) {
        OwnNode searchingPointer = firstNode;

        while (searchingPointer!=null) {
            if (searchingPointer.getValue().equals(value))
                return searchingPointer;
            searchingPointer = searchingPointer.getNextNode();
        }
        return null;
    }

    public void addItem(String value) {
        OwnNode newNode = createNodeFromValue(value);

        linkNodeIntoTheList(newNode);
        increaseListSize();
    }

    private void linkNodeIntoTheList(OwnNode newNode) {
        if (firstNode == null) {
            linkFirstNode(newNode);
        } else {
            linkNotFirstNode(newNode);
        }
    }

    private void linkFirstNode(OwnNode newNode) {
        firstNode = newNode;
        lastNode = firstNode;
    }

    private void linkNotFirstNode(OwnNode newNode) {
        lastNode.setNextNode(newNode);
        newNode.setPrevNode(lastNode);
        lastNode = newNode;
    }


    public boolean deleteItem(String nodeValue) {
        OwnNode foundNode = find(nodeValue);

        if (foundNode != null) {
            removeNode(foundNode);
            return true;
        } else return false;

    }

    private void removeNode(OwnNode foundNode) {
        unlinkNode(foundNode);
        decreaseListSize();
    }

    private void unlinkNode(OwnNode foundNode) {
        OwnNode prevNodeToDeleted = foundNode.getPrevNode();
        OwnNode nextNodeToDeleted = foundNode.getNextNode();

        unlinkFromNeighbourNodes(prevNodeToDeleted, nextNodeToDeleted);
        updateFirstLastNodes(foundNode);
    }

    private void unlinkFromNeighbourNodes(OwnNode prevNodeToDeleted, OwnNode nextNodeToDeleted) {

        if (prevNodeToDeleted != null) prevNodeToDeleted.setNextNode(nextNodeToDeleted);
        if (nextNodeToDeleted != null) nextNodeToDeleted.setPrevNode(prevNodeToDeleted);
    }

    private void updateFirstLastNodes(OwnNode foundNode) {
        if (foundNode == firstNode) firstNode = null;
        if (foundNode == lastNode) lastNode = lastNode.getPrevNode();
    }

    public int getSize() {
        return size;
    }

    public String[] toValuesArray() {
        if (size == 0)
            return null;

        String valuesToReturn[] = new String[size];
        OwnNode currentNode = firstNode;
        int i = 0;

        while (currentNode != null) {
            valuesToReturn[i++] = currentNode.getValue();
            currentNode = currentNode.getNextNode();
        }

        return valuesToReturn;
    }

    private OwnNode createNodeFromValue(String value) {
        return new OwnNode(value);
    }

    private void increaseListSize() {
        size++;
    }

    private void decreaseListSize() {
        size--;
    }

    public OwnNode getLastNode() {
        return lastNode;
    }
}