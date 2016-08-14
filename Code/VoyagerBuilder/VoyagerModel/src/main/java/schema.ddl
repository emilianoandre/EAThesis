
    create table Voyager.bugsystem (
        idBugSystem integer not null auto_increment,
        createdBy varchar(100) not null,
        createdOn datetime,
        name varchar(45) not null,
        url varchar(200) not null,
        bugSystemType integer not null,
        primary key (idBugSystem)
    );

    create table Voyager.bugsystemtype (
        idBugSystemType integer not null auto_increment,
        createdBy varchar(100) not null,
        createdOn datetime,
        name varchar(45) not null,
        primary key (idBugSystemType)
    );

    create table Voyager.permission (
        idPermission integer not null auto_increment,
        createdBy varchar(100) not null,
        createdOn datetime,
        name varchar(100) not null,
        primary key (idPermission)
    );

    create table Voyager.project (
        idProject integer not null auto_increment,
        createdBy varchar(100) not null,
        createdOn datetime,
        name varchar(100) not null,
        ruleManager integer,
        bugSystem integer not null,
        primary key (idProject)
    );

    create table Voyager.rulemanager (
        idRuleManager integer not null auto_increment,
        createdBy varchar(100) not null,
        createdOn datetime,
        name varchar(100) not null,
        url varchar(200) not null,
        ruleManagerType integer not null,
        primary key (idRuleManager)
    );

    create table Voyager.rulemanagertype (
        idRuleManagerType integer not null auto_increment,
        createdBy varchar(100) not null,
        createdOn datetime,
        name varchar(45) not null,
        primary key (idRuleManagerType)
    );

    create table Voyager.user (
        idUser integer not null auto_increment,
        createdBy varchar(100) not null,
        createdOn datetime,
        email varchar(100) not null,
        loggedIn bit not null,
        name varchar(155) not null,
        password varchar(100) not null,
        userName varchar(100) not null,
        userType integer not null,
        primary key (idUser)
    );

    create table Voyager.userproject (
        idUserProject integer not null auto_increment,
        createdBy varchar(100) not null,
        createdOn datetime,
        projectPassword varchar(100),
        projectUserName varchar(100),
        ruleManagerPassword varchar(100),
        ruleManagerUserName varchar(100),
        project integer not null,
        user integer not null,
        primary key (idUserProject)
    );

    create table Voyager.usertype (
        idUserType integer not null auto_increment,
        createdBy varchar(100) not null,
        createdOn datetime,
        name varchar(45) not null,
        primary key (idUserType)
    );

    create table Voyager.usertypepermission (
        idUserTypePermission integer not null auto_increment,
        createdBy varchar(100) not null,
        createdOn datetime,
        value varchar(45),
        permission integer not null,
        userType integer not null,
        primary key (idUserTypePermission)
    );

    alter table Voyager.user 
        add constraint UK_4bakctviobmdk6ddh2nwg08c2  unique (userName);

    alter table Voyager.bugsystem 
        add constraint FK_k7deglj1v5a67it6f9ny9bdjp 
        foreign key (bugSystemType) 
        references Voyager.bugsystemtype (idBugSystemType);

    alter table Voyager.project 
        add constraint FK_g1lanh0tdkhg74w05upvjtcar 
        foreign key (bugSystem) 
        references Voyager.bugsystem (idBugSystem);

    alter table Voyager.rulemanager 
        add constraint FK_pupw22neq7ats3hcn6m82rk2t 
        foreign key (ruleManagerType) 
        references Voyager.rulemanagertype (idRuleManagerType);

    alter table Voyager.user 
        add constraint FK_4m4f9s6b8fjbml6y7ffdxaw0b 
        foreign key (userType) 
        references Voyager.usertype (idUserType);

    alter table Voyager.userproject 
        add constraint FK_3va4frs4ajw83b5635t53nbe0 
        foreign key (project) 
        references Voyager.project (idProject);

    alter table Voyager.userproject 
        add constraint FK_mv9u4xdgklqj1w52a5458nc8o 
        foreign key (user) 
        references Voyager.user (idUser);

    alter table Voyager.usertypepermission 
        add constraint FK_6bso6ra6wb4i3huh1dmqie9iu 
        foreign key (permission) 
        references Voyager.permission (idPermission);

    alter table Voyager.usertypepermission 
        add constraint FK_6ubp67wqqnwt1m32sor5u93h9 
        foreign key (userType) 
        references Voyager.usertype (idUserType);
