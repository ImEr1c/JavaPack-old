package com.batmanatorul.api.datapack.Components;

public class TextComponent implements Component {
    private final String text;
    private boolean bold;
    private boolean italic;
    private boolean underlined;
    private boolean strikethrough;
    private boolean obfuscated;

    public TextComponent(String text) {
        this.text = text;
    }

    public TextComponent bold() {
        bold = true;
        return this;
    }

    public TextComponent italic() {
        italic = true;
        return this;
    }

    public TextComponent underlined() {
        underlined = true;
        return this;
    }

    public TextComponent strikeThrough() {
        strikethrough = true;
        return this;
    }

    public TextComponent obsfucated() {
        obfuscated = true;
        return this;
    }


    //+ Custom font
}
