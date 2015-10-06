package com.brave.backend.dao.model;

/**
 * The Class MsgWithContent.
 */
public class MsgWithContent extends Msg
{
    
    /** The text. */
    protected String text;
    
    /** The multi media. */
    protected String multiMedia;
    
    /**
     * Gets the text.
     *
     * @return the text
     */
    public String getText()
    {
        return text;
    }
    
    /**
     * Sets the text.
     *
     * @param text the new text
     */
    public void setText(String text)
    {
        this.text = text;
    }
    
    /**
     * Gets the multi media.
     *
     * @return the multi media
     */
    public String getMultiMedia()
    {
        return multiMedia;
    }
    
    /**
     * Sets the multi media.
     *
     * @param multiMedia the new multi media
     */
    public void setMultiMedia(String multiMedia)
    {
        this.multiMedia = multiMedia;
    }
    
    /** {@inheritDoc} */
    
    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("MsgWithContent [text=");
        builder.append(text);
        builder.append(", multiMedia=");
        builder.append(multiMedia);
        builder.append(", msgId=");
        builder.append(msgId);
        builder.append(", contentId=");
        builder.append(contentId);
        builder.append(", uid=");
        builder.append(uid);
        builder.append(", createTime=");
        builder.append(createTime);
        builder.append(", updateTime=");
        builder.append(updateTime);
        builder.append("]");
        return builder.toString();
    }
    
}
