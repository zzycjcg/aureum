package com.brave.backend.dao.model;

/**
 * The Class CommentWithContent.
 *
 * @author zhiyong zhu at 2015-10-6
 * @since v0.0.1
 */
public class CommentWithContent extends Comment
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
        builder.append("CommentWithContent [text=");
        builder.append(text);
        builder.append(", multiMedia=");
        builder.append(multiMedia);
        builder.append(", commentId=");
        builder.append(commentId);
        builder.append(", msgId=");
        builder.append(msgId);
        builder.append(", uid=");
        builder.append(uid);
        builder.append(", contentId=");
        builder.append(contentId);
        builder.append(", createTime=");
        builder.append(createTime);
        builder.append(", updateTime=");
        builder.append(updateTime);
        builder.append("]");
        return builder.toString();
    }
    
}
