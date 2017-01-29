CREATE SCHEMA heartbeat;

CREATE TABLE hb_user(
	userName nvarchar(50) NOT NULL,
	userId int IDENTITY(1,1) NOT NULL,
	imId nvarchar(45) NOT NULL DEFAULT (''),
	password nvarchar(45) NOT NULL,
	unlockCode nvarchar(64) NULL DEFAULT (NULL),
	sipUsername nvarchar(150) NOT NULL DEFAULT (''),
	sipExtensionPW nvarchar(50) NOT NULL DEFAULT (''),
	roleName nvarchar(128) NULL DEFAULT (NULL),
	sysRoleName nvarchar(45) NULL DEFAULT ('user'),
	isInternal tinyint NOT NULL,
	externalPhoneNumber nvarchar(512) NOT NULL,
	accessCardNumber nvarchar(150) NULL DEFAULT (''),
	accessCardNumberMasked nvarchar(150) NULL DEFAULT (''),
	name nvarchar(50) NULL DEFAULT (''),
	heartbeatPhoneNumber nvarchar(50) NULL DEFAULT (''),
	email nvarchar(50) NULL DEFAULT (''),
	lastLoginTime datetime NULL DEFAULT (NULL),
	customOnlineStatusMessage nvarchar(512) NULL DEFAULT (NULL),
	hospitalId int NULL DEFAULT (NULL),
	pagerNumber varchar(135) NULL,
	deleted tinyint NULL DEFAULT ('0'),
	isLastDeviceTurnkey tinyint NULL DEFAULT ('1'),
	customOnlineStatus tinyint NULL DEFAULT (NULL),
	newUser tinyint NULL DEFAULT ('0'),
	mustResetUnlockCode tinyint NULL DEFAULT ('0'),
	lastUpdateDateTime datetime NOT NULL,
	lastSyncUpdateDateTime datetime NOT NULL,
	isMuted tinyint NOT NULL DEFAULT ((0)),
	hasAcceptedTermsAndConditions tinyint NOT NULL DEFAULT ('0'),
	ldapUniqueId nvarchar(64) NULL,
	lastLdapSync datetime NULL,
	preventLdapSync tinyint NOT NULL DEFAULT ('0'),
	pendingDeletion tinyint NOT NULL DEFAULT ('0'),
	firstName nvarchar(64) NULL,
	lastName nvarchar(64) NULL,
	initials nvarchar(8) NULL,
	title nvarchar(64) NULL,
	department nvarchar(64) NULL,
	company nvarchar(64) NULL);
	
	CREATE TABLE hb_hierarchy(
	levelId int NOT NULL,
	levelName nvarchar(145) NOT NULL,
	levelType nvarchar(45) NOT NULL DEFAULT (''),
	subType nvarchar(45) NOT NULL DEFAULT ('NORM'),
	abbreviation nvarchar(256) NULL DEFAULT (''),
	parentId int NOT NULL DEFAULT ('0'),
	startIndex int NULL DEFAULT (NULL),
	endIndex int NULL DEFAULT (NULL),
	hospitalId int NOT NULL DEFAULT ('0'),
	colorCode nvarchar(45) NOT NULL DEFAULT ('white'),
	isActive tinyint NULL DEFAULT ('1'),
	massDischarge tinyint NOT NULL DEFAULT ('0'),
	clientLicenseId nvarchar(255) NULL DEFAULT (NULL),
	deleted tinyint NOT NULL DEFAULT ('0'));
