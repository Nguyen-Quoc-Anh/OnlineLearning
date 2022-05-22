-- Add Account
insert into Account
values ('bill@gmail.com', '12345', 1, 1)
-- Add Expert
insert into Expert
values (1, 'Bill gates', 'https://upload.wikimedia.org/wikipedia/commons/thumb/a/a0/Bill_Gates_2018.jpg/375px-Bill_Gates_2018.jpg', '098989898', 'William Henry Gates III (born October 28, 1955) is an American business magnate, software developer, investor, author, and philanthropist. He is a co-founder of Microsoft, along with his late childhood friend Paul Allen.')
-- Add Course
insert into Course(courseName, description, courseImage, expertID, price)
values
('HTML', 'HyperText Markup Language', 'https://tmarketing.vn/wp-content/uploads/2021/09/html.jpg', 1, 10),
('CSS', 'Cascading Style Sheets', 'https://upload.wikimedia.org/wikipedia/commons/thumb/d/d5/CSS3_logo_and_wordmark.svg/1200px-CSS3_logo_and_wordmark.svg.png', 1, 10),
('JS', 'Javascript', 'https://cdn.pixabay.com/photo/2015/04/23/17/41/javascript-736400_960_720.png', 1, 0),
('C#', 'C-Sharp', 'https://upload.wikimedia.org/wikipedia/commons/thumb/0/0d/C_Sharp_wordmark.svg/640px-C_Sharp_wordmark.svg.png', 1, 0),
('Java', 'Java', 'https://laptrinhcanban.com/css/images/page/java-co-ban-cho-nguoi-moi-bat-dau.webp', 1, 0),
('HTML', 'HyperText Markup Language', 'https://tmarketing.vn/wp-content/uploads/2021/09/html.jpg', 1, 0),
('CSS', 'Cascading Style Sheets', 'https://upload.wikimedia.org/wikipedia/commons/thumb/d/d5/CSS3_logo_and_wordmark.svg/1200px-CSS3_logo_and_wordmark.svg.png', 1, 0),
('JS', 'Javascript', 'https://cdn.pixabay.com/photo/2015/04/23/17/41/javascript-736400_960_720.png', 1, 0),
('C#', 'C-Sharp', 'https://upload.wikimedia.org/wikipedia/commons/thumb/0/0d/C_Sharp_wordmark.svg/640px-C_Sharp_wordmark.svg.png', 1, 0),
('Java', 'Java', 'https://laptrinhcanban.com/css/images/page/java-co-ban-cho-nguoi-moi-bat-dau.webp', 1, 0),
('HTML', 'HyperText Markup Language', 'https://tmarketing.vn/wp-content/uploads/2021/09/html.jpg', 1, 0),
('CSS', 'Cascading Style Sheets', 'https://upload.wikimedia.org/wikipedia/commons/thumb/d/d5/CSS3_logo_and_wordmark.svg/1200px-CSS3_logo_and_wordmark.svg.png', 1, 0),
('JS', 'Javascript', 'https://cdn.pixabay.com/photo/2015/04/23/17/41/javascript-736400_960_720.png', 1, 0),
('C#', 'C-Sharp', 'https://upload.wikimedia.org/wikipedia/commons/thumb/0/0d/C_Sharp_wordmark.svg/640px-C_Sharp_wordmark.svg.png', 1, 0),
('Java', 'Java', 'https://laptrinhcanban.com/css/images/page/java-co-ban-cho-nguoi-moi-bat-dau.webp', 1, 0),
('HTML', 'HyperText Markup Language', 'https://tmarketing.vn/wp-content/uploads/2021/09/html.jpg', 1, 0),
('CSS', 'Cascading Style Sheets', 'https://upload.wikimedia.org/wikipedia/commons/thumb/d/d5/CSS3_logo_and_wordmark.svg/1200px-CSS3_logo_and_wordmark.svg.png', 1, 0),
('JS', 'Javascript', 'https://cdn.pixabay.com/photo/2015/04/23/17/41/javascript-736400_960_720.png', 1, 0),
('C#', 'C-Sharp', 'https://upload.wikimedia.org/wikipedia/commons/thumb/0/0d/C_Sharp_wordmark.svg/640px-C_Sharp_wordmark.svg.png', 1, 0),
('Java', 'Java', 'https://laptrinhcanban.com/css/images/page/java-co-ban-cho-nguoi-moi-bat-dau.webp', 1, 0)
-- Add category
insert into Category
values
('Data Science'),
('Business Analytics'),
('Cyber Security'),
('Machine Learning'),
('Software Development'),
('DepOps'),
('Project Management')






