
connect sys/oracle as sysdba
create tablespace proo DATAFILE '/u01/app/oracle/oradata/proo.dbf' SIZE 100M EXTENT MANAGEMENT LOCAL AUTOALLOCATE;
declare
userexist integer;
begin
select count(*) into userexist from dba_users where username='PROO';
if (userexist = 0) then
execute immediate 'create user proo identified by proo default tablespace proo';
end if;
end;
/
ALTER USER "PROO" DEFAULT TABLESPACE "PROO" TEMPORARY TABLESPACE "TEMP" ACCOUNT UNLOCK ;
exit;