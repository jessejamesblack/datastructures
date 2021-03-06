public class LLBookNode {
    private Object info;
    private LLBookNode link;        //self-referential class example

    public LLBookNode(Object info) {
        this.info = info;
        link = null;
    }

    public void setInfo(Object info)
    // Sets info string of this LLBookNode.
    {
        this.info = info;
    }

    public Object getInfo()
    // Returns info string of this LLBookNode.
    {
        return info;
    }

    public void setLink(LLBookNode link)
    // Sets link of this LLBookNode.
    {
        this.link = link;
    }

    public LLBookNode getLink()
    // Returns link of this LLBookNode.
    {
        return link;
    }
}
 
 