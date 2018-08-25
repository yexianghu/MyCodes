package com.yezi.aac.repository;

import java.util.List;

public interface Data {

    interface Content {}

    class TextContent implements Content {

        public final String content;

        public TextContent(String content) {
            this.content = content;
        }
    }

    class ImageContent implements Content {
        public final String url;

        public ImageContent(String url) {
            this.url = url;
        }
    }

    List<Content> getContent();
}
