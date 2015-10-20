create index IX_CBB2416B on datahandler_Hero (groupId);
create index IX_627489E9 on datahandler_Hero (groupId, uuid_);
create index IX_1E51A408 on datahandler_Hero (heroId);
create index IX_B2AF32B5 on datahandler_Hero (uuid_);
create index IX_1A517E53 on datahandler_Hero (uuid_, companyId);
create unique index IX_94BB7D95 on datahandler_Hero (uuid_, groupId);

create index IX_71F898B on datahandler_hero (groupId);
create index IX_332BDDC9 on datahandler_hero (groupId, uuid_);
create index IX_5A0AD7E8 on datahandler_hero (heroId);
create index IX_831002D5 on datahandler_hero (uuid_);
create index IX_9A835A33 on datahandler_hero (uuid_, companyId);
create unique index IX_6572D175 on datahandler_hero (uuid_, groupId);