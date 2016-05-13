
connect sys/oracle as sysdba
create tablespace pro4 DATAFILE '/u01/app/oracle/oradata/pro4.dbf' SIZE 100M EXTENT MANAGEMENT LOCAL AUTOALLOCATE;
declare
userexist integer;
begin
select count(*) into userexist from dba_users where username='PRO4';
if (userexist = 0) then
execute immediate 'create user pro4 identified by pro4 default tablespace pro4';
end if;
end;
/
ALTER USER "PRO4" DEFAULT TABLESPACE "PRO4" TEMPORARY TABLESPACE "TEMP" ACCOUNT UNLOCK ;
exit;