[adodon@localhost bin]$ ss -tulpn | rg qemu
tcp   LISTEN 0      5               127.0.0.1:5555       0.0.0.0:*    users:(("qemu-system-x86",pid=26721,fd=66))
tcp   LISTEN 0      4               127.0.0.1:5554       0.0.0.0:*    users:(("qemu-system-x86",pid=26721,fd=70))
tcp   LISTEN 0      5               127.0.0.1:37593      0.0.0.0:*    users:(("qemu-system-x86",pid=26721,fd=68))
tcp   LISTEN 0      5                   [::1]:41559         [::]:*    users:(("qemu-system-x86",pid=26721,fd=8)) 
tcp   LISTEN 0      5                   [::1]:32829         [::]:*    users:(("qemu-system-x86",pid=26721,fd=11))
tcp   LISTEN 0      4096   [::ffff:127.0.0.1]:8554             *:*    users:(("qemu-system-x86",pid=26721,fd=83))
tcp   LISTEN 0      5                   [::1]:37593         [::]:*    users:(("qemu-system-x86",pid=26721,fd=69))
tcp   LISTEN 0      5                   [::1]:5555          [::]:*    users:(("qemu-system-x86",pid=26721,fd=67))
tcp   LISTEN 0      4                   [::1]:5554          [::]:*    users:(("qemu-system-x86",pid=26721,fd=71))

