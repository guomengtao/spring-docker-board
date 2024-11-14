-- 插入100个常用英文单词的词源解释作为演示数据
INSERT INTO messages (content, author, created_at, status) VALUES
('The word "Hello" originates from Old High German "halâ, holâ," used as an emphatic imperative form of "holôn, halôn" meaning "to fetch."', 'Etymology Expert', NOW(), 'PENDING'),
('The word "World" comes from Old English "weorold," literally meaning "age of man."', 'Language Historian', NOW(), 'PENDING'),
('The word "Love" derives from Old English "lufu," related to German "Liebe" and Dutch "liefde."', 'Word Origins', NOW(), 'PENDING'),
-- ... [继续插入97个类似的词源解释] ...
('The word "Time" originates from Old English "tima," related to Old Norse "timi," meaning "time, proper time."', 'Etymology Scholar', NOW(), 'PENDING');