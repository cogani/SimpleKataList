public class OwnNode {
    private final String value;
    private OwnNode prevOwnNode;
    private OwnNode nextOwnNode;

    public OwnNode(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }

    public void setPrevNode(OwnNode prevOwnNode){
        this.prevOwnNode = prevOwnNode;
    }

    public void setNextNode(OwnNode nextOwnNode){
        this.nextOwnNode = nextOwnNode;
    }
    public OwnNode getPrevNode(){
        return prevOwnNode;
    }
    public OwnNode getNextNode(){
        return nextOwnNode;
    }

    @Override
    public String toString() {
        return "OwnNode{" +
                "value='" + value + '\'' +
                ", prevOwnNode=" + prevOwnNode +
                ", nextOwnNode=" + nextOwnNode +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OwnNode ownNode = (OwnNode) o;

        if (nextOwnNode != null ? !nextOwnNode.equals(ownNode.nextOwnNode) : ownNode.nextOwnNode != null) return false;
        if (prevOwnNode != null ? !prevOwnNode.equals(ownNode.prevOwnNode) : ownNode.prevOwnNode != null) return false;
        if (value != null ? !value.equals(ownNode.value) : ownNode.value != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = value != null ? value.hashCode() : 0;
        result = 31 * result + (prevOwnNode != null ? prevOwnNode.hashCode() : 0);
        result = 31 * result + (nextOwnNode != null ? nextOwnNode.hashCode() : 0);
        return result;
    }
}
