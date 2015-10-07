package com.brave.backend.dao.model;

/**
 * The Class Content.
 *
 * @author zhiyong zhu at 2015-10-7
 * @since v0.0.1
 */
public class Content
{
    
    /** The content id. */
    protected String contentId;
    
    /** The text. */
    protected String text;
    
    /** The multi media. */
    protected String multiMedia;
    
    /**
     * Gets the content id.
     *
     * @return the content id
     */
    public String getContentId()
    {
        return contentId;
    }
    
    /**
     * Sets the content id.
     *
     * @param contentId the new content id
     */
    public void setContentId(String contentId)
    {
        this.contentId = contentId;
    }
    
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
        builder.append("Content [contentId=");
        builder.append(contentId);
        builder.append(", text=");
        builder.append(text);
        builder.append(", multiMedia=");
        builder.append(multiMedia);
        builder.append("]");
        return builder.toString();
    }
}
