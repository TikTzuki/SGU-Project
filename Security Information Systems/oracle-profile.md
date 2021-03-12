SESSIONS_PER_USER 
Specify the number of concurrent sessions to which you want to limit the user. \
Chỉ định số lượng phiên đồng thời mà bạn muốn giới hạn người dùng.

CPU_PER_SESSION  
Specify the CPU time limit for a session, expressed in hundredth of seconds.

CPU_PER_CALL  
Specify the CPU time limit for a call (a parse, execute, or fetch), expressed in hundredths of seconds.

CONNECT_TIME 
Specify the total elapsed time limit for a session, expressed in minutes.

IDLE_TIME 
Specify the permitted periods of continuous inactive time during a session, expressed in minutes. Long-running queries and other operations are not subject to this limit. \
Chỉ định khoảng thời gian không hoạt động liên tục được phép trong một phiên, được biểu thị bằng phút. Các truy vấn chạy dài và các hoạt động khác không phải tuân theo giới hạn này.

LOGICAL_READS_PER_SESSION 
Specify the permitted number of data blocks read in a session, including blocks read from memory and disk.\
Chỉ định số lượng khối dữ liệu được phép đọc trong một phiên, bao gồm cả các khối được đọc từ bộ nhớ và đĩa.

LOGICAL_READS_PER_CALL 
Specify the permitted number of data blocks read for a call to process a SQL statement (a parse, execute, or fetch).\
Chỉ định số lượng khối dữ liệu được phép đọc cho lệnh gọi xử lý câu lệnh SQL (phân tích cú pháp, thực thi hoặc tìm nạp).

PRIVATE_SGA 
Specify the amount of private space a session can allocate in the shared pool of the system global area (SGA). Please refer to size_clause for information on that clause. \
Chỉ định số lượng không gian riêng tư mà một phiên có thể phân bổ trong nhóm chia sẻ của khu vực toàn cầu hệ thống (SGA). Vui lòng tham khảo size_clause để biết thông tin về điều khoản đó.

COMPOSITE_LIMIT  
Specify the total resource cost for a session, expressed in service units. Oracle Database calculates the total service units as a weighted sum of CPU_PER_SESSION, CONNECT_TIME, LOGICAL_READS_PER_SESSION, and PRIVATE_SGA. \
Chỉ định tổng chi phí tài nguyên cho một phiên, được biểu thị bằng đơn vị dịch vụ. Cơ sở dữ liệu Oracle tính toán tổng số đơn vị dịch vụ dưới dạng tổng trọng số của CPU_PER_SESSION, CONNECT_TIME, LOGICAL_READS_PER_SESSION và PRIVATE_SGA.

password_parameters \
Use the following clauses to set password parameters. Parameters that set lengths of time are interpreted in number of days. For testing purposes you can specify minutes (n/1440) or even seconds (n/86400).
Sử dụng các mệnh đề sau để đặt các thông số mật khẩu. Các tham số đặt độ dài thời gian được diễn giải theo số ngày. Đối với mục đích thử nghiệm, bạn có thể chỉ định phút (n / 1440) hoặc thậm chí giây (n / 86400).

FAILED_LOGIN_ATTEMPTS  
Specify the number of failed attempts to log in to the user account before the account is locked.

PASSWORD_LIFE_TIME  
Specify the number of days the same password can be used for authentication. If you also set a value for PASSWORD_GRACE_TIME, the password expires if it is not changed within the grace period, and further connections are rejected. If you do not set a value for PASSWORD_GRACE_TIME, its default of UNLIMITED will cause the database to issue a warning but let the user continue to connect indefinitely.

PASSWORD_REUSE_TIME and PASSWORD_REUSE_MAX  
These two parameters must be set in conjunction with each other. PASSWORD_REUSE_TIME specifies the number of days before which a password cannot be reused. PASSWORD_REUSE_MAX specifies the number of password changes required before the current password can be reused. For these parameter to have any effect, you must specify an integer for both of them.

If you specify an integer for both of these parameters, then the user cannot reuse a password until the password has been changed the password the number of times specified for PASSWORD_REUSE_MAX during the number of days specified for PASSWORD_REUSE_TIME.

For example, if you specify PASSWORD_REUSE_TIME to 30 and PASSWORD_REUSE_MAX to 10, then the user can reuse the password after 30 days if the password has already been changed 10 times.

If you specify an integer for either of these parameters and specify UNLIMITED for the other, then the user can never reuse a password.

If you specify DEFAULT for either parameter, then Oracle Database uses the value defined in the DEFAULT profile. By default, all parameters are set to UNLIMITED in the DEFAULT profile. If you have not changed the default setting of UNLIMITED in the DEFAULT profile, then the database treats the value for that parameter as UNLIMITED.

If you set both of these parameters to UNLIMITED, then the database ignores both of them.

PASSWORD_LOCK_TIME  
Specify the number of days an account will be locked after the specified number of consecutive failed login attempts.

PASSWORD_GRACE_TIME  
Specify the number of days after the grace period begins during which a warning is issued and login is allowed. If the password is not changed during the grace period, the password expires.

PASSWORD_VERIFY_FUNCTION  
The PASSWORD_VERIFY_FUNCTION clause lets a PL/SQL password complexity verification script be passed as an argument to the CREATE PROFILE statement. Oracle Database provides a default script, but you can create your own routine or use third-party software instead.

For function, specify the name of the password complexity verification routine.

Specify NULL to indicate that no password verification is performed.

If you specify expr for any of the password parameters, the expression can be of any form except scalar subquery expression.