package com.higher.login_register_home.Objects;

import java.util.List;

//_____Login Code
// Coded By: Duncan
// on: Still in production
// Edited by:
//Tested by:
public class QuestionObject
{

    private String imageShape;
    private Integer imageLink;
    private List<String> options;

    public QuestionObject(){}

    public QuestionObject(String shape, Integer link, List<String> option)
    {
        setShape(shape);
        setLink(link);
        setOption(option);
    }

    public String getShape() {
        return imageShape;
    }

    public void setShape(String shape) {
        this.imageShape = shape;
    }

    public Integer getLink() {
        return imageLink;
    }

    public void setLink(Integer link) {
        this.imageLink = link;
    }

    public List<String> getOption() {
        return options;
    }

    public void setOption(List<String> option) {
        this.options = option;
    }
}
