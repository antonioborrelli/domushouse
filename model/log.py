import time
import datetime


def log(output):
    ts = time.time()
    data_file = datetime.datetime.fromtimestamp(ts).strftime('%Y-%m-%d')
    st = datetime.datetime.fromtimestamp(ts).strftime('%Y-%m-%d %H:%M:%S')
    out_file = open("/var/www/html/log/log_python-"+data_file+".txt","a")
    out_file.write("[ "+st+" ]"+output+"\n")
    out_file.close()