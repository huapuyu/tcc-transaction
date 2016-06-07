USE TCC_CAP;
TRUNCATE TABLE `CAP_CAPITAL_ACCOUNT`;
TRUNCATE TABLE `TCC_TRANSACTION`;
INSERT INTO `CAP_CAPITAL_ACCOUNT` (`CAPITAL_ACCOUNT_ID`,`BALANCE_AMOUNT`,`USER_ID`) VALUES (1,1000,1000);
INSERT INTO `CAP_CAPITAL_ACCOUNT` (`CAPITAL_ACCOUNT_ID`,`BALANCE_AMOUNT`,`USER_ID`) VALUES (2,2000,2000);

USE TCC_ORD;
TRUNCATE TABLE `ORD_ORDER`;
TRUNCATE TABLE `ORD_ORDER_LINE`;
TRUNCATE TABLE `TCC_TRANSACTION`;

USE TCC_RED;
TRUNCATE TABLE `RED_RED_PACKET_ACCOUNT`;
TRUNCATE TABLE `TCC_TRANSACTION`;
INSERT INTO `RED_RED_PACKET_ACCOUNT` (`RED_PACKET_ACCOUNT_ID`,`BALANCE_AMOUNT`,`USER_ID`) VALUES (1,1000,1000);
INSERT INTO `RED_RED_PACKET_ACCOUNT` (`RED_PACKET_ACCOUNT_ID`,`BALANCE_AMOUNT`,`USER_ID`) VALUES (2,2000,2000);

USE TCC_LEVEL3;
TRUNCATE TABLE `LEVEL_LEVEL3_ACCOUNT`;
TRUNCATE TABLE `TCC_TRANSACTION`;
INSERT INTO `LEVEL_LEVEL3_ACCOUNT` (`LEVEL3_ACCOUNT_ID`,`BALANCE_AMOUNT`,`USER_ID`) VALUES (1,1000,1000);
INSERT INTO `LEVEL_LEVEL3_ACCOUNT` (`LEVEL3_ACCOUNT_ID`,`BALANCE_AMOUNT`,`USER_ID`) VALUES (2,2000,2000);
