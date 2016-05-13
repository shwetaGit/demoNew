
connect sys/oracle as sysdba
create tablespace prolic DATAFILE '/u01/app/oracle/oradata/prolic.dbf' SIZE 100M EXTENT MANAGEMENT LOCAL AUTOALLOCATE;
declare
userexist integer;
begin
select count(*) into userexist from dba_users where username='PROLIC';
if (userexist = 0) then
execute immediate 'create user prolic identified by prolic default tablespace prolic';
end if;
end;
/
ALTER USER "PROLIC" DEFAULT TABLESPACE "PROLIC" TEMPORARY TABLESPACE "TEMP" ACCOUNT UNLOCK ;
exit;