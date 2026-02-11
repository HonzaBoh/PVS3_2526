import socket

HOST = "127.0.0.1"
PORT = 10001

with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as client_socket:
    client_socket.connect((HOST, PORT))
    print("Pripojeno k serveru...")

    while True:
        msg = input("Poslat (quit): ")
        if msg == "quit":
            break

        client_socket.sendall(msg.encode())

        data = client_socket.recv(1024)
        print("Echo: ", data.decode( ))