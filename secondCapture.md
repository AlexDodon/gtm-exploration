[adodon@localhost bin]$ ss -tulpn | rg qemu
udp   UNCONN 0      0                 0.0.0.0:39871      0.0.0.0:*    users:(("qemu-system-x86",pid=26721,fd=121))
udp   UNCONN 0      0                 0.0.0.0:40824      0.0.0.0:*    users:(("qemu-system-x86",pid=26721,fd=134))
udp   UNCONN 0      0                 0.0.0.0:49146      0.0.0.0:*    users:(("qemu-system-x86",pid=26721,fd=114))
udp   UNCONN 0      0                 0.0.0.0:40977      0.0.0.0:*    users:(("qemu-system-x86",pid=26721,fd=133))
udp   UNCONN 0      0                 0.0.0.0:50790      0.0.0.0:*    users:(("qemu-system-x86",pid=26721,fd=118))
udp   UNCONN 0      0                 0.0.0.0:52103      0.0.0.0:*    users:(("qemu-system-x86",pid=26721,fd=142))
udp   UNCONN 0      0                 0.0.0.0:45060      0.0.0.0:*    users:(("qemu-system-x86",pid=26721,fd=116))
udp   UNCONN 0      0                 0.0.0.0:46231      0.0.0.0:*    users:(("qemu-system-x86",pid=26721,fd=120))
udp   UNCONN 0      0                       *:47383            *:*    users:(("qemu-system-x86",pid=26721,fd=126))
udp   UNCONN 0      0                       *:49272            *:*    users:(("qemu-system-x86",pid=26721,fd=122))
udp   UNCONN 0      0                       *:51162            *:*    users:(("qemu-system-x86",pid=26721,fd=117))
udp   UNCONN 0      0                       *:43415            *:*    users:(("qemu-system-x86",pid=26721,fd=119))
udp   UNCONN 0      0                       *:60081            *:*    users:(("qemu-system-x86",pid=26721,fd=123))
udp   UNCONN 0      0                       *:52027            *:*    users:(("qemu-system-x86",pid=26721,fd=125))
tcp   LISTEN 0      5               127.0.0.1:5555       0.0.0.0:*    users:(("qemu-system-x86",pid=26721,fd=66)) 
tcp   LISTEN 0      4               127.0.0.1:5554       0.0.0.0:*    users:(("qemu-system-x86",pid=26721,fd=70)) 
tcp   LISTEN 0      5               127.0.0.1:37593      0.0.0.0:*    users:(("qemu-system-x86",pid=26721,fd=68)) 
tcp   LISTEN 0      5                   [::1]:41559         [::]:*    users:(("qemu-system-x86",pid=26721,fd=8))  
tcp   LISTEN 0      5                   [::1]:32829         [::]:*    users:(("qemu-system-x86",pid=26721,fd=11)) 
tcp   LISTEN 0      4096   [::ffff:127.0.0.1]:8554             *:*    users:(("qemu-system-x86",pid=26721,fd=83)) 
tcp   LISTEN 0      5                   [::1]:37593         [::]:*    users:(("qemu-system-x86",pid=26721,fd=69)) 
tcp   LISTEN 0      5                   [::1]:5555          [::]:*    users:(("qemu-system-x86",pid=26721,fd=67)) 
tcp   LISTEN 0      4                   [::1]:5554          [::]:*    users:(("qemu-system-x86",pid=26721,fd=71)) 

- interesting ports:
    - 41559 - tcp encrypted
        - likely ide debug comms; not interesting
    - 40824 - quic encrypted
        - connected to 142.250.200.228
            - whois lookup sais google
    - 8554 - not really
    - 5555 - contains plain text logs likely from the adb console