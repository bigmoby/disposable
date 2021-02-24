server {
        {{ if not .ssl }}
        listen {{ .port }} default_server;
        {{ else }}
        listen {{ .port }} default_server ssl http2;
        {{ end }}

        {{ if .ssl }}
        include /etc/nginx/includes/ssl_params.conf;

        ssl_certificate /ssl/{{ .certfile }};
        ssl_certificate_key /ssl/{{ .keyfile }};
        {{ end }}
        
        location / {
                proxy_pass http://192.168.1.1:80;
                proxy_redirect off;
                proxy_set_header Host $host;
                proxy_set_header X-Real-IP $remote_addr;
                proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
                proxy_set_header X-Forwarded-Host $server_name;
                proxy_set_header X-Forwarded-Proto $scheme;
                proxy_http_version 1.1;
                proxy_set_header Upgrade $http_upgrade;
                proxy_set_header Connection "Upgrade";
                chunked_transfer_encoding off;
                proxy_buffering off;
                proxy_cache off;
        }
}
