/*
Navicat Oracle Data Transfer
Oracle Client Version : 11.2.0.4.0

Source Server         : Local
Source Server Version : 110200
Source Host           : 127.0.0.1:1521
Source Schema         : CCETC

Target Server Type    : ORACLE
Target Server Version : 110200
File Encoding         : 65001

Date: 2019-12-09 15:38:32
*/


-- ----------------------------
-- Table structure for T_AREA
-- ----------------------------
DROP TABLE "CCETC"."T_AREA";
CREATE TABLE "CCETC"."T_AREA" (
"AREAID" VARCHAR2(10 BYTE) NOT NULL ,
"AREANAME" VARCHAR2(20 BYTE) NULL ,
"CREATEID" VARCHAR2(20 BYTE) NULL ,
"CREATEDATE" DATE NULL ,
"EDITID" VARCHAR2(20 BYTE) NULL ,
"EDITDATE" DATE NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of T_AREA
-- ----------------------------

-- ----------------------------
-- Table structure for T_AUTH
-- ----------------------------
DROP TABLE "CCETC"."T_AUTH";
CREATE TABLE "CCETC"."T_AUTH" (
"AUTHID" VARCHAR2(20 BYTE) NOT NULL ,
"AUTHNAME" VARCHAR2(100 BYTE) NULL ,
"SEQ" NUMBER(5) NULL ,
"URL" VARCHAR2(255 BYTE) NULL ,
"PAUTHID" VARCHAR2(20 BYTE) NULL ,
"STATUS" CHAR(1 BYTE) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of T_AUTH
-- ----------------------------
INSERT INTO "CCETC"."T_AUTH" VALUES ('yhglxg', '用户权限管理-修改页面', '1', '/user/userRoleEdit.action', 'qxgl', '1');
INSERT INTO "CCETC"."T_AUTH" VALUES ('yhgljq', '用户权限管理-禁启按钮', '2', '/user/userUpdateStatus.action', 'qxgl', '1');
INSERT INTO "CCETC"."T_AUTH" VALUES ('xtgl', '系统管理', '1', null, '#', '0');
INSERT INTO "CCETC"."T_AUTH" VALUES ('qygl', '区域管理', '2', null, '#', '0');
INSERT INTO "CCETC"."T_AUTH" VALUES ('kctx', '课程体系', '3', null, '#', '0');
INSERT INTO "CCETC"."T_AUTH" VALUES ('ywxx', '业务信息', '4', null, '#', '0');
INSERT INTO "CCETC"."T_AUTH" VALUES ('yhgl', '用户管理', '5', null, '#', '0');
INSERT INTO "CCETC"."T_AUTH" VALUES ('jsgl', '教室管理', '6', null, '#', '0');
INSERT INTO "CCETC"."T_AUTH" VALUES ('kbgl', '开班管理', '7', null, '#', '0');
INSERT INTO "CCETC"."T_AUTH" VALUES ('qxgl', '用户权限管理', '1', '/user/userRole.action?row=10&page=1', 'xtgl', '0');
INSERT INTO "CCETC"."T_AUTH" VALUES ('zsgl', '角色管理', '2', '/system/role.action?row=10&page=1', 'xtgl', '0');
INSERT INTO "CCETC"."T_AUTH" VALUES ('glqu', '区域管理', '1', '.action', 'qygl', '0');
INSERT INTO "CCETC"."T_AUTH" VALUES ('bmgl', '部门管理', '2', '.action', 'qygl', '0');
INSERT INTO "CCETC"."T_AUTH" VALUES ('zwgl', '职务管理', '3', '.action', 'qygl', '0');
INSERT INTO "CCETC"."T_AUTH" VALUES ('bzkctx', '标准课程体系', '1', '.action', 'kctx', '0');
INSERT INTO "CCETC"."T_AUTH" VALUES ('dqbj', '当前班级', '1', '.action', 'ywxx', '0');
INSERT INTO "CCETC"."T_AUTH" VALUES ('sybj', '所有班级', '2', '.action', 'ywxx', '0');
INSERT INTO "CCETC"."T_AUTH" VALUES ('yggl', '用户管理', '1', '.action', 'yhgl', '0');
INSERT INTO "CCETC"."T_AUTH" VALUES ('gljs', '教室管理', '1', '.action', 'jsgl', '0');
INSERT INTO "CCETC"."T_AUTH" VALUES ('glkb', '开班管理', '1', '.action', 'kbgl', '0');
INSERT INTO "CCETC"."T_AUTH" VALUES ('chmm', '用户权限管理-重置密码按钮', '3', '/user/userUpdatePwdaction', 'qxgl', '1');
INSERT INTO "CCETC"."T_AUTH" VALUES ('qxglxgbc', '用户权限管理-修改页面-保存按钮', '1', '/user/userRoleUpdate.action', 'yhglxg', '1');

-- ----------------------------
-- Table structure for T_CLASSROOM
-- ----------------------------
DROP TABLE "CCETC"."T_CLASSROOM";
CREATE TABLE "CCETC"."T_CLASSROOM" (
"CLASSROOMID" NUMBER(5) NOT NULL ,
"CALSSROOMNAME" VARCHAR2(20 BYTE) NULL ,
"AREAID" VARCHAR2(10 BYTE) NULL ,
"CONTAIN" NUMBER(5) NULL ,
"STATUS" CHAR(1 BYTE) NULL ,
"CREATEID" VARCHAR2(20 BYTE) NULL ,
"CREATEDATE" DATE NULL ,
"EDITID" VARCHAR2(20 BYTE) NULL ,
"EDITDATE" DATE NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of T_CLASSROOM
-- ----------------------------

-- ----------------------------
-- Table structure for T_CLAZZ
-- ----------------------------
DROP TABLE "CCETC"."T_CLAZZ";
CREATE TABLE "CCETC"."T_CLAZZ" (
"CLAZZID" NUMBER(5) NOT NULL ,
"AREAID" VARCHAR2(10 BYTE) NULL ,
"TECHNOLOGYID" VARCHAR2(10 BYTE) NULL ,
"CLASSROOMID" NUMBER(5) NULL ,
"TIMETABLEID" NUMBER(5) NULL ,
"COUNT" NUMBER(5) NULL ,
"PROPERTIES" CHAR(1 BYTE) NULL ,
"STARTDATE" DATE NULL ,
"ENDDATE" DATE NULL ,
"TEACHER" VARCHAR2(20 BYTE) NULL ,
"ASSISTANT" VARCHAR2(20 BYTE) NULL ,
"CLAZZMASTER" VARCHAR2(20 BYTE) NULL ,
"REMARK" VARCHAR2(100 BYTE) NULL ,
"CREATEID" VARCHAR2(20 BYTE) NULL ,
"CREATEDATE" DATE NULL ,
"EDITID" VARCHAR2(20 BYTE) NULL ,
"EDITDATE" DATE NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of T_CLAZZ
-- ----------------------------

-- ----------------------------
-- Table structure for T_COURSE
-- ----------------------------
DROP TABLE "CCETC"."T_COURSE";
CREATE TABLE "CCETC"."T_COURSE" (
"COURSEID" NUMBER(5) NOT NULL ,
"COURSENAME" VARCHAR2(20 BYTE) NULL ,
"TECHNOLOGYID" VARCHAR2(10 BYTE) NOT NULL ,
"FILEURL" VARCHAR2(255 BYTE) NULL ,
"CREATEID" VARCHAR2(20 BYTE) NULL ,
"CREATEDATE" DATE NULL ,
"EDITID" VARCHAR2(20 BYTE) NULL ,
"EDITDATE" DATE NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of T_COURSE
-- ----------------------------

-- ----------------------------
-- Table structure for T_DEPT
-- ----------------------------
DROP TABLE "CCETC"."T_DEPT";
CREATE TABLE "CCETC"."T_DEPT" (
"DEPTID" VARCHAR2(10 BYTE) NOT NULL ,
"DEPTNAME" VARCHAR2(20 BYTE) NULL ,
"AREAID" VARCHAR2(10 BYTE) NOT NULL ,
"CREATEID" VARCHAR2(20 BYTE) NULL ,
"CREATEDATE" DATE NULL ,
"EDITID" VARCHAR2(20 BYTE) NULL ,
"EDIRTDATE" DATE NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of T_DEPT
-- ----------------------------

-- ----------------------------
-- Table structure for T_DUTIES
-- ----------------------------
DROP TABLE "CCETC"."T_DUTIES";
CREATE TABLE "CCETC"."T_DUTIES" (
"DUTIESID" VARCHAR2(10 BYTE) NOT NULL ,
"DUTIESNAME" VARCHAR2(20 BYTE) NULL ,
"AREAID" VARCHAR2(10 BYTE) NULL ,
"DEPTID" VARCHAR2(10 BYTE) NULL ,
"CREATEID" VARCHAR2(20 BYTE) NULL ,
"CREATEDATE" DATE NULL ,
"EDITID" VARCHAR2(20 BYTE) NULL ,
"EDITDATE" DATE NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of T_DUTIES
-- ----------------------------

-- ----------------------------
-- Table structure for T_ROLE
-- ----------------------------
DROP TABLE "CCETC"."T_ROLE";
CREATE TABLE "CCETC"."T_ROLE" (
"ROLEID" NUMBER(5) NOT NULL ,
"ROLE" VARCHAR2(20 BYTE) NULL ,
"CREATEID" VARCHAR2(20 BYTE) NULL ,
"CREATEDATE" DATE NULL ,
"EDITID" VARCHAR2(20 BYTE) NULL ,
"EDITDATE" DATE NULL ,
"REMARK" VARCHAR2(40 BYTE) NULL ,
"STATUS" NUMBER(5) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of T_ROLE
-- ----------------------------
INSERT INTO "CCETC"."T_ROLE" VALUES ('17', '管理员', 'admin', TO_DATE('2019-12-09 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), null, null, '管理员角色', '1');
INSERT INTO "CCETC"."T_ROLE" VALUES ('1', '教学总监', null, null, 'admin', TO_DATE('2019-12-09 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '总监角色', '1');
INSERT INTO "CCETC"."T_ROLE" VALUES ('2', '教学督导', null, null, 'admin', TO_DATE('2019-12-09 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '督导角色', '1');
INSERT INTO "CCETC"."T_ROLE" VALUES ('12', '班主任', null, null, 'admin', TO_DATE('2019-12-09 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '班主任角色', '1');

-- ----------------------------
-- Table structure for T_ROLEAUTH
-- ----------------------------
DROP TABLE "CCETC"."T_ROLEAUTH";
CREATE TABLE "CCETC"."T_ROLEAUTH" (
"ROLEID" NUMBER(5) NOT NULL ,
"AUTHID" VARCHAR2(20 BYTE) NOT NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of T_ROLEAUTH
-- ----------------------------
INSERT INTO "CCETC"."T_ROLEAUTH" VALUES ('17', 'xtgl');
INSERT INTO "CCETC"."T_ROLEAUTH" VALUES ('17', 'qxgl');
INSERT INTO "CCETC"."T_ROLEAUTH" VALUES ('17', 'yhglxg');
INSERT INTO "CCETC"."T_ROLEAUTH" VALUES ('17', 'qxglxgbc');
INSERT INTO "CCETC"."T_ROLEAUTH" VALUES ('17', 'yhgljq');
INSERT INTO "CCETC"."T_ROLEAUTH" VALUES ('17', 'chmm');
INSERT INTO "CCETC"."T_ROLEAUTH" VALUES ('17', 'zsgl');
INSERT INTO "CCETC"."T_ROLEAUTH" VALUES ('17', 'qygl');
INSERT INTO "CCETC"."T_ROLEAUTH" VALUES ('17', 'glqu');
INSERT INTO "CCETC"."T_ROLEAUTH" VALUES ('17', 'bmgl');
INSERT INTO "CCETC"."T_ROLEAUTH" VALUES ('17', 'zwgl');
INSERT INTO "CCETC"."T_ROLEAUTH" VALUES ('17', 'kctx');
INSERT INTO "CCETC"."T_ROLEAUTH" VALUES ('17', 'bzkctx');
INSERT INTO "CCETC"."T_ROLEAUTH" VALUES ('17', 'ywxx');
INSERT INTO "CCETC"."T_ROLEAUTH" VALUES ('17', 'dqbj');
INSERT INTO "CCETC"."T_ROLEAUTH" VALUES ('17', 'sybj');
INSERT INTO "CCETC"."T_ROLEAUTH" VALUES ('17', 'yhgl');
INSERT INTO "CCETC"."T_ROLEAUTH" VALUES ('17', 'yggl');
INSERT INTO "CCETC"."T_ROLEAUTH" VALUES ('17', 'jsgl');
INSERT INTO "CCETC"."T_ROLEAUTH" VALUES ('17', 'gljs');
INSERT INTO "CCETC"."T_ROLEAUTH" VALUES ('17', 'kbgl');
INSERT INTO "CCETC"."T_ROLEAUTH" VALUES ('17', 'glkb');
INSERT INTO "CCETC"."T_ROLEAUTH" VALUES ('2', 'dqbj');
INSERT INTO "CCETC"."T_ROLEAUTH" VALUES ('2', 'sybj');
INSERT INTO "CCETC"."T_ROLEAUTH" VALUES ('1', 'kctx');
INSERT INTO "CCETC"."T_ROLEAUTH" VALUES ('1', 'bzkctx');
INSERT INTO "CCETC"."T_ROLEAUTH" VALUES ('2', 'ywxx');
INSERT INTO "CCETC"."T_ROLEAUTH" VALUES ('12', 'xtgl');
INSERT INTO "CCETC"."T_ROLEAUTH" VALUES ('12', 'qxgl');
INSERT INTO "CCETC"."T_ROLEAUTH" VALUES ('12', 'yhgljq');
INSERT INTO "CCETC"."T_ROLEAUTH" VALUES ('12', 'qygl');
INSERT INTO "CCETC"."T_ROLEAUTH" VALUES ('12', 'glqu');
INSERT INTO "CCETC"."T_ROLEAUTH" VALUES ('12', 'bmgl');
INSERT INTO "CCETC"."T_ROLEAUTH" VALUES ('12', 'zwgl');
INSERT INTO "CCETC"."T_ROLEAUTH" VALUES ('12', 'ywxx');
INSERT INTO "CCETC"."T_ROLEAUTH" VALUES ('12', 'dqbj');
INSERT INTO "CCETC"."T_ROLEAUTH" VALUES ('12', 'sybj');
INSERT INTO "CCETC"."T_ROLEAUTH" VALUES ('12', 'yhgl');
INSERT INTO "CCETC"."T_ROLEAUTH" VALUES ('12', 'yggl');
INSERT INTO "CCETC"."T_ROLEAUTH" VALUES ('12', 'jsgl');
INSERT INTO "CCETC"."T_ROLEAUTH" VALUES ('12', 'gljs');
INSERT INTO "CCETC"."T_ROLEAUTH" VALUES ('12', 'kbgl');
INSERT INTO "CCETC"."T_ROLEAUTH" VALUES ('12', 'glkb');

-- ----------------------------
-- Table structure for T_TECHNOLOGY
-- ----------------------------
DROP TABLE "CCETC"."T_TECHNOLOGY";
CREATE TABLE "CCETC"."T_TECHNOLOGY" (
"TECHNOLOGYID" VARCHAR2(10 BYTE) NOT NULL ,
"TECHNOLOGYNAME" VARCHAR2(20 BYTE) NULL ,
"AREAID" VARCHAR2(10 BYTE) NULL ,
"CREATEID" VARCHAR2(20 BYTE) NULL ,
"CREATEDATE" DATE NULL ,
"EDITID" VARCHAR2(20 BYTE) NULL ,
"EDITDATE" DATE NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of T_TECHNOLOGY
-- ----------------------------

-- ----------------------------
-- Table structure for T_TIMETABLE
-- ----------------------------
DROP TABLE "CCETC"."T_TIMETABLE";
CREATE TABLE "CCETC"."T_TIMETABLE" (
"TIMETABLEID" NUMBER(5) NOT NULL ,
"CLAZZID" NUMBER(5) NULL ,
"DAYSUM" NUMBER(5) NULL ,
"CONTENT" VARCHAR2(200 BYTE) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of T_TIMETABLE
-- ----------------------------

-- ----------------------------
-- Table structure for T_USER
-- ----------------------------
DROP TABLE "CCETC"."T_USER";
CREATE TABLE "CCETC"."T_USER" (
"USERID" VARCHAR2(20 BYTE) NOT NULL ,
"PASSWORD" CHAR(32 BYTE) NULL ,
"USERNAME" VARCHAR2(30 BYTE) NULL ,
"SEX" CHAR(1 BYTE) DEFAULT 1  NULL ,
"PROPERTIES" CHAR(1 BYTE) NULL ,
"AREAID" VARCHAR2(10 BYTE) NULL ,
"DEPTID" VARCHAR2(10 BYTE) NULL ,
"DUTIESID" VARCHAR2(10 BYTE) NULL ,
"TECHNOLOGYID" VARCHAR2(10 BYTE) NULL ,
"LEVEL" CHAR(1 BYTE) NULL ,
"TRAVEL" CHAR(1 BYTE) NULL ,
"PHONE" VARCHAR2(11 BYTE) NULL ,
"QQ" VARCHAR2(20 BYTE) NULL ,
"WECHAT" VARCHAR2(20 BYTE) NULL ,
"EMAIL" VARCHAR2(30 BYTE) NULL ,
"ROLEID" NUMBER(5) NULL ,
"STATUS" NUMBER(5) NULL ,
"CREATEID" VARCHAR2(20 BYTE) NULL ,
"CREATEDATE" DATE NULL ,
"EDITID" VARCHAR2(20 BYTE) NULL ,
"EDITDATE" DATE NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of T_USER
-- ----------------------------
INSERT INTO "CCETC"."T_USER" VALUES ('hanmeimei', '81dc9bdb52d04dc20036dbd8313ed055', '韩梅梅', '0', null, null, null, null, null, null, null, null, null, null, null, '12', '1', null, null, 'admin', TO_DATE('2019-12-09 00:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO "CCETC"."T_USER" VALUES ('weihua', null, '魏华', '0', null, null, null, null, null, null, null, null, null, null, null, '2', '1', null, null, 'admin', TO_DATE('2019-12-09 00:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO "CCETC"."T_USER" VALUES ('admin', '21232f297a57a5a743894a0e4a801fc3', '管理员', '1', null, null, null, null, null, null, null, null, null, null, null, '17', '1', null, null, 'admin', TO_DATE('2019-12-09 00:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO "CCETC"."T_USER" VALUES ('lilei', '81dc9bdb52d04dc20036dbd8313ed055', '李雷', '1', null, null, null, null, null, null, null, null, null, null, null, '1', '1', null, null, 'admin', TO_DATE('2019-12-09 00:00:00', 'YYYY-MM-DD HH24:MI:SS'));

-- ----------------------------
-- Sequence structure for APARTMENT_SEQUENCE
-- ----------------------------
DROP SEQUENCE "CCETC"."APARTMENT_SEQUENCE";
CREATE SEQUENCE "CCETC"."APARTMENT_SEQUENCE"
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 999999999999999999999999999
 START WITH 1000
 CACHE 20;

-- ----------------------------
-- Sequence structure for AREA_SEQUENCE
-- ----------------------------
DROP SEQUENCE "CCETC"."AREA_SEQUENCE";
CREATE SEQUENCE "CCETC"."AREA_SEQUENCE"
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 999999999999999999999999999
 START WITH 1000
 CACHE 20;

-- ----------------------------
-- Sequence structure for POSITION_SEQUENCE
-- ----------------------------
DROP SEQUENCE "CCETC"."POSITION_SEQUENCE";
CREATE SEQUENCE "CCETC"."POSITION_SEQUENCE"
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 999999999999999999999999999
 START WITH 1000
 CACHE 20;

-- ----------------------------
-- Sequence structure for SEQ_AUTHORITY
-- ----------------------------
DROP SEQUENCE "CCETC"."SEQ_AUTHORITY";
CREATE SEQUENCE "CCETC"."SEQ_AUTHORITY"
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 999999999999999999999999999
 START WITH 1000
 CACHE 20;

-- ----------------------------
-- Sequence structure for SEQ_CLASSCOURSE
-- ----------------------------
DROP SEQUENCE "CCETC"."SEQ_CLASSCOURSE";
CREATE SEQUENCE "CCETC"."SEQ_CLASSCOURSE"
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 999999999999999999999999999
 START WITH 1000
 CACHE 20;

-- ----------------------------
-- Sequence structure for SEQ_CLASSROOM
-- ----------------------------
DROP SEQUENCE "CCETC"."SEQ_CLASSROOM";
CREATE SEQUENCE "CCETC"."SEQ_CLASSROOM"
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 999999999999999999999999999
 START WITH 1000
 CACHE 20;

-- ----------------------------
-- Sequence structure for SEQ_COURSESYS
-- ----------------------------
DROP SEQUENCE "CCETC"."SEQ_COURSESYS";
CREATE SEQUENCE "CCETC"."SEQ_COURSESYS"
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 999999999999999999999999999
 START WITH 1000
 CACHE 20;

-- ----------------------------
-- Sequence structure for SEQ_EMPLOYEE
-- ----------------------------
DROP SEQUENCE "CCETC"."SEQ_EMPLOYEE";
CREATE SEQUENCE "CCETC"."SEQ_EMPLOYEE"
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 999999999999999999999999999
 START WITH 1000
 CACHE 20;

-- ----------------------------
-- Sequence structure for SEQ_MYROLE
-- ----------------------------
DROP SEQUENCE "CCETC"."SEQ_MYROLE";
CREATE SEQUENCE "CCETC"."SEQ_MYROLE"
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 9999999
 START WITH 23
 CACHE 20
 CYCLE ;

-- ----------------------------
-- Sequence structure for SEQ_ROLE
-- ----------------------------
DROP SEQUENCE "CCETC"."SEQ_ROLE";
CREATE SEQUENCE "CCETC"."SEQ_ROLE"
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 999999999999999999999999999
 START WITH 1000
 CACHE 20;

-- ----------------------------
-- Sequence structure for SEQ_STARTCLASS
-- ----------------------------
DROP SEQUENCE "CCETC"."SEQ_STARTCLASS";
CREATE SEQUENCE "CCETC"."SEQ_STARTCLASS"
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 999999999
 START WITH 1000
 CACHE 20;

-- ----------------------------
-- Sequence structure for TECH_SEQUENCE
-- ----------------------------
DROP SEQUENCE "CCETC"."TECH_SEQUENCE";
CREATE SEQUENCE "CCETC"."TECH_SEQUENCE"
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 999999999999999999999999999
 START WITH 1000
 CACHE 20;

-- ----------------------------
-- Indexes structure for table T_AREA
-- ----------------------------

-- ----------------------------
-- Checks structure for table T_AREA
-- ----------------------------
ALTER TABLE "CCETC"."T_AREA" ADD CHECK ("AREAID" IS NOT NULL);
ALTER TABLE "CCETC"."T_AREA" ADD CHECK ("AREAID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table T_AREA
-- ----------------------------
ALTER TABLE "CCETC"."T_AREA" ADD PRIMARY KEY ("AREAID");

-- ----------------------------
-- Indexes structure for table T_AUTH
-- ----------------------------

-- ----------------------------
-- Checks structure for table T_AUTH
-- ----------------------------
ALTER TABLE "CCETC"."T_AUTH" ADD CHECK ("AUTHID" IS NOT NULL);
ALTER TABLE "CCETC"."T_AUTH" ADD CHECK ("AUTHID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table T_AUTH
-- ----------------------------
ALTER TABLE "CCETC"."T_AUTH" ADD PRIMARY KEY ("AUTHID");

-- ----------------------------
-- Indexes structure for table T_CLASSROOM
-- ----------------------------

-- ----------------------------
-- Checks structure for table T_CLASSROOM
-- ----------------------------
ALTER TABLE "CCETC"."T_CLASSROOM" ADD CHECK ("CLASSROOMID" IS NOT NULL);
ALTER TABLE "CCETC"."T_CLASSROOM" ADD CHECK ("CLASSROOMID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table T_CLASSROOM
-- ----------------------------
ALTER TABLE "CCETC"."T_CLASSROOM" ADD PRIMARY KEY ("CLASSROOMID");

-- ----------------------------
-- Indexes structure for table T_CLAZZ
-- ----------------------------

-- ----------------------------
-- Checks structure for table T_CLAZZ
-- ----------------------------
ALTER TABLE "CCETC"."T_CLAZZ" ADD CHECK ("CLAZZID" IS NOT NULL);
ALTER TABLE "CCETC"."T_CLAZZ" ADD CHECK ("CLAZZID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table T_CLAZZ
-- ----------------------------
ALTER TABLE "CCETC"."T_CLAZZ" ADD PRIMARY KEY ("CLAZZID");

-- ----------------------------
-- Indexes structure for table T_COURSE
-- ----------------------------

-- ----------------------------
-- Checks structure for table T_COURSE
-- ----------------------------
ALTER TABLE "CCETC"."T_COURSE" ADD CHECK ("COURSEID" IS NOT NULL);
ALTER TABLE "CCETC"."T_COURSE" ADD CHECK ("TECHNOLOGYID" IS NOT NULL);
ALTER TABLE "CCETC"."T_COURSE" ADD CHECK ("COURSEID" IS NOT NULL);
ALTER TABLE "CCETC"."T_COURSE" ADD CHECK ("TECHNOLOGYID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table T_COURSE
-- ----------------------------
ALTER TABLE "CCETC"."T_COURSE" ADD PRIMARY KEY ("COURSEID");

-- ----------------------------
-- Indexes structure for table T_DEPT
-- ----------------------------

-- ----------------------------
-- Checks structure for table T_DEPT
-- ----------------------------
ALTER TABLE "CCETC"."T_DEPT" ADD CHECK ("DEPTID" IS NOT NULL);
ALTER TABLE "CCETC"."T_DEPT" ADD CHECK ("AREAID" IS NOT NULL);
ALTER TABLE "CCETC"."T_DEPT" ADD CHECK ("DEPTID" IS NOT NULL);
ALTER TABLE "CCETC"."T_DEPT" ADD CHECK ("AREAID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table T_DEPT
-- ----------------------------
ALTER TABLE "CCETC"."T_DEPT" ADD PRIMARY KEY ("DEPTID");

-- ----------------------------
-- Indexes structure for table T_DUTIES
-- ----------------------------

-- ----------------------------
-- Checks structure for table T_DUTIES
-- ----------------------------
ALTER TABLE "CCETC"."T_DUTIES" ADD CHECK ("DUTIESID" IS NOT NULL);
ALTER TABLE "CCETC"."T_DUTIES" ADD CHECK ("DUTIESID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table T_DUTIES
-- ----------------------------
ALTER TABLE "CCETC"."T_DUTIES" ADD PRIMARY KEY ("DUTIESID");

-- ----------------------------
-- Indexes structure for table T_ROLE
-- ----------------------------

-- ----------------------------
-- Checks structure for table T_ROLE
-- ----------------------------
ALTER TABLE "CCETC"."T_ROLE" ADD CHECK ("ROLEID" IS NOT NULL);
ALTER TABLE "CCETC"."T_ROLE" ADD CHECK ("ROLEID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table T_ROLE
-- ----------------------------
ALTER TABLE "CCETC"."T_ROLE" ADD PRIMARY KEY ("ROLEID");

-- ----------------------------
-- Checks structure for table T_ROLEAUTH
-- ----------------------------
ALTER TABLE "CCETC"."T_ROLEAUTH" ADD CHECK ("ROLEID" IS NOT NULL);
ALTER TABLE "CCETC"."T_ROLEAUTH" ADD CHECK ("AUTHID" IS NOT NULL);

-- ----------------------------
-- Indexes structure for table T_TECHNOLOGY
-- ----------------------------

-- ----------------------------
-- Checks structure for table T_TECHNOLOGY
-- ----------------------------
ALTER TABLE "CCETC"."T_TECHNOLOGY" ADD CHECK ("TECHNOLOGYID" IS NOT NULL);
ALTER TABLE "CCETC"."T_TECHNOLOGY" ADD CHECK ("TECHNOLOGYID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table T_TECHNOLOGY
-- ----------------------------
ALTER TABLE "CCETC"."T_TECHNOLOGY" ADD PRIMARY KEY ("TECHNOLOGYID");

-- ----------------------------
-- Indexes structure for table T_TIMETABLE
-- ----------------------------

-- ----------------------------
-- Checks structure for table T_TIMETABLE
-- ----------------------------
ALTER TABLE "CCETC"."T_TIMETABLE" ADD CHECK ("TIMETABLEID" IS NOT NULL);
ALTER TABLE "CCETC"."T_TIMETABLE" ADD CHECK ("TIMETABLEID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table T_TIMETABLE
-- ----------------------------
ALTER TABLE "CCETC"."T_TIMETABLE" ADD PRIMARY KEY ("TIMETABLEID");

-- ----------------------------
-- Indexes structure for table T_USER
-- ----------------------------

-- ----------------------------
-- Checks structure for table T_USER
-- ----------------------------
ALTER TABLE "CCETC"."T_USER" ADD CHECK ("USERID" IS NOT NULL);
ALTER TABLE "CCETC"."T_USER" ADD CHECK ("USERID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table T_USER
-- ----------------------------
ALTER TABLE "CCETC"."T_USER" ADD PRIMARY KEY ("USERID");

-- ----------------------------
-- Foreign Key structure for table "CCETC"."T_CLASSROOM"
-- ----------------------------
ALTER TABLE "CCETC"."T_CLASSROOM" ADD FOREIGN KEY ("AREAID") REFERENCES "CCETC"."T_AREA" ("AREAID");

-- ----------------------------
-- Foreign Key structure for table "CCETC"."T_CLAZZ"
-- ----------------------------
ALTER TABLE "CCETC"."T_CLAZZ" ADD FOREIGN KEY ("AREAID") REFERENCES "CCETC"."T_AREA" ("AREAID");
ALTER TABLE "CCETC"."T_CLAZZ" ADD FOREIGN KEY ("TECHNOLOGYID") REFERENCES "CCETC"."T_TECHNOLOGY" ("TECHNOLOGYID");
ALTER TABLE "CCETC"."T_CLAZZ" ADD FOREIGN KEY ("CLASSROOMID") REFERENCES "CCETC"."T_CLASSROOM" ("CLASSROOMID");
ALTER TABLE "CCETC"."T_CLAZZ" ADD FOREIGN KEY ("TEACHER") REFERENCES "CCETC"."T_USER" ("USERID");
ALTER TABLE "CCETC"."T_CLAZZ" ADD FOREIGN KEY ("ASSISTANT") REFERENCES "CCETC"."T_USER" ("USERID");
ALTER TABLE "CCETC"."T_CLAZZ" ADD FOREIGN KEY ("CLAZZMASTER") REFERENCES "CCETC"."T_USER" ("USERID");

-- ----------------------------
-- Foreign Key structure for table "CCETC"."T_COURSE"
-- ----------------------------
ALTER TABLE "CCETC"."T_COURSE" ADD FOREIGN KEY ("TECHNOLOGYID") REFERENCES "CCETC"."T_TECHNOLOGY" ("TECHNOLOGYID");

-- ----------------------------
-- Foreign Key structure for table "CCETC"."T_ROLEAUTH"
-- ----------------------------
ALTER TABLE "CCETC"."T_ROLEAUTH" ADD FOREIGN KEY ("ROLEID") REFERENCES "CCETC"."T_ROLE" ("ROLEID");
ALTER TABLE "CCETC"."T_ROLEAUTH" ADD FOREIGN KEY ("AUTHID") REFERENCES "CCETC"."T_AUTH" ("AUTHID");

-- ----------------------------
-- Foreign Key structure for table "CCETC"."T_TECHNOLOGY"
-- ----------------------------
ALTER TABLE "CCETC"."T_TECHNOLOGY" ADD FOREIGN KEY ("AREAID") REFERENCES "CCETC"."T_AREA" ("AREAID");

-- ----------------------------
-- Foreign Key structure for table "CCETC"."T_TIMETABLE"
-- ----------------------------
ALTER TABLE "CCETC"."T_TIMETABLE" ADD FOREIGN KEY ("CLAZZID") REFERENCES "CCETC"."T_CLAZZ" ("CLAZZID");

-- ----------------------------
-- Foreign Key structure for table "CCETC"."T_USER"
-- ----------------------------
ALTER TABLE "CCETC"."T_USER" ADD FOREIGN KEY ("AREAID") REFERENCES "CCETC"."T_AREA" ("AREAID");
ALTER TABLE "CCETC"."T_USER" ADD FOREIGN KEY ("DEPTID") REFERENCES "CCETC"."T_DEPT" ("DEPTID");
ALTER TABLE "CCETC"."T_USER" ADD FOREIGN KEY ("DUTIESID") REFERENCES "CCETC"."T_DUTIES" ("DUTIESID");
ALTER TABLE "CCETC"."T_USER" ADD FOREIGN KEY ("ROLEID") REFERENCES "CCETC"."T_ROLE" ("ROLEID");
