create table Account (
	accountID int identity(1, 1) primary key not null,
	email varchar(255) not null,
	password varchar(255) not null,
	emailVerify bit default 0,
	status bit default 1
)

create table Student (
	studentID int primary key references Account(accountID),
	name nvarchar(255) not null,
	cashInWallet money default 0,
	imageURL nvarchar(max)
)

create table Expert (
	expertID int primary key references Account(accountID),
	name nvarchar(255) not null,
	imageURL nvarchar(max),
	phone varchar(20),
	description text
)

create table Admin (
	adminID int primary key references Account(accountID),
	name nvarchar(255) not null,
	imageURL nvarchar(max),
	phone varchar(20)
)

create table Transaction_History (
	transctionID int identity(1, 1) primary key not null,
	studentID int references Account(accountID),
	time datetime DEFAULT(getdate()),
	amount money not null
)

create table Category (
	categoryID int identity(1, 1) primary key not null,
	categoryName nvarchar(100) not null,
)

create table Course (
	courseID int identity(1, 1) primary key not null,
	courseName nvarchar(255) not null,
	description text not null,
	courseImage nvarchar(max) not null,
	expertID int references Expert(expertID) not null,
	price money not null,
	releasedDate datetime DEFAULT(getdate()),
	status bit default 1 
)

create table Enroll (
	courseID int references Course(courseID) not null,
	studentID int references Student(studentID) not null,
	registeredDate datetime DEFAULT(getdate()),
	primary key (courseID, studentID)
)

create table Rate (
	rateID int identity(1, 1) primary key not null,
	star int not null, 
	accountID int references Account(accountID) not null,
	content text,
	courseID int references Course(courseID) not null
)

create table Course_Category (
	courseID int references Course(courseID) not null,
	categoryID int references Category(categoryID) not null,
	primary key (courseID, categoryID)
)

create table Chapter (
	chapterID int identity(1, 1) primary key not null,
	chapterName nvarchar(255) not null,
	courseID int references Course(courseID) not null,
	content text not null,
)

create table Lesson (
	lessonID int identity(1, 1) primary key not null,
	lessonName nvarchar(255),
	chapterID int references Chapter(chapterID) not null,
	videoUrl nvarchar(max) not null,
	content text not null,
)

create table Quiz (
	quizID int identity(1, 1) primary key not null,
	chapterID int references Chapter(chapterID) not null,
	quizName nvarchar(255),
	passRate int default 50,
	status bit default 1
)

create table Question (
	questionID int identity(1, 1) primary key not null,
	content text not null,
	explaination text not null,
	quizID int references Quiz(quizID),
	status bit default 1
)

create table Answer (
	answerID int identity(1, 1) primary key not null,
	questionID int references Question(questionID) not null,
	content text,
	isTrue bit default 0 
)

create table Quiz_Attended (
	attendedID int identity(1, 1) primary key not null,
	startTime datetime DEFAULT(getdate()),
	accountID int references Account(accountID) not null,
	grade float not null,
	quizID int references Quiz(quizID) not null
)

create table Question_Answered (
	attendedID int references Quiz_Attended(attendedID) not null,
	questionID int references Quiz(quizID) not null,
	answerID int references Answer(answerID) not null,
)

create table Learned_Lesson (
	studentID int references Student(studentID) not null,
	lessonID int references Lesson(lessonID) not null,
)