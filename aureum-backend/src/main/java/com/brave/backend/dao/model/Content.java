package com.brave.backend.dao.model;

public class Content
{
    protected String contentId;
    
    protected String text;
    
    protected String multiMedia;
    
    public String getContentId()
    {
        return contentId;
    }
    
    public void setContentId(String contentId)
    {
        this.contentId = contentId;
    }
    
    public String getText()
    {
        return text;
    }
    
    public void setText(String text)
    {
        this.text = text;
    }
    
    public String getMultiMedia()
    {
        return multiMedia;
    }
    
    public void setMultiMedia(String multiMedia)
    {
        this.multiMedia = multiMedia;
    }
    
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
