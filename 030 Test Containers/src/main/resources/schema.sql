DROP TABLE IF EXISTS Post;

CREATE TABLE IF NOT EXISTS Post(
    id INT NOT NULL,
    title VARCHAR(250) NOT NULL,
    content VARCHAR(250) NOT NULL,
    author VARCHAR(250) NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO Post (id, title, content, author)
VALUES
    (1, 'My First Post Title', 'This is the content of my first post.', 'John Doe'),
    (2, 'Another Interesting Post', 'Here I share some interesting information.', 'Jane Smith'),
    (3, 'A Post About Technology', 'Exploring the latest advancements in tech.', 'Tech Enthusiast'),
    (4, 'Beautiful Nature Photography', 'Stunning pictures of nature captured by me.', 'Nature Lover'),
    (5, 'Tips for Healthy Living', 'Sharing some practical tips to stay healthy.', 'Health Advocate');