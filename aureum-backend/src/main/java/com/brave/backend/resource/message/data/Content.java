package com.brave.backend.resource.message.data;

import java.util.List;

/**
 * The Class Content.
 *
 * @author zhiyong zhu at 2015-10-7
 * @since v0.0.1
 */
public class Content
{
    /** The text. */
    private String text;
    
    /** The image urls. */
    private List<String> imageUrls;
    
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
     * Gets the image urls.
     *
     * @return the image urls
     */
    public List<String> getImageUrls()
    {
        return imageUrls;
    }
    
    /**
     * Sets the image urls.
     *
     * @param imageUrls the new image urls
     */
    public void setImageUrls(List<String> imageUrls)
    {
        this.imageUrls = imageUrls;
    }
    
    /** {@inheritDoc} */
    
    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("Content [text=");
        builder.append(text);
        builder.append(", imageUrls=");
        builder.append(imageUrls);
        builder.append("]");
        return builder.toString();
    }
}
