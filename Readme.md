# Getting Started

To deploy Therap Technee app you will need to have the following applications up and running:
* Consul (for service discovery)

Consul:

* To install consul on local system, follow the instructions on this tutorial: https://developer.hashicorp.com/consul/docs/install
* To run consul on local system, execute the following command:

       consul agent -server -bootstrap-expect=1 -data-dir=consul-data -ui -bind=127.0.0.1

***

## Need Golang Installed in the System
#### For Ubuntu: (Golang 1.20 Preferable)
* Install go if not installed. Follow the steps below to install go in the system:
    1. Remove the existing golang

               sudo apt-get purge golang
    2. Download the latest version from the official site. [click here](https://go.dev/dl/)
    3. Copy and extract the downloaded version in `/usr/local/` folder

             sudo cp go-<version>.tar.gz /usr/local/
             cd /usr/local/
             sudo tar -xvf go-<version>.tar.gz
    4. Create .go directory in home. (It is easy to install the necessary packages without admin privilege)

             mkdir ~/.go
    5. Set up the following environment variables in `~/.bashrc` file

             export GOROOT=/usr/local/go
             export GOPATH=~/.go
             export PATH=$PATH:$GOROOT/bin:$GOPATH/bin
    6. Update the go command

           sudo update-alternatives --install "/usr/bin/go" "go" "/usr/local/go/bin/go" 0
           sudo update-alternatives --set go /usr/local/go/bin/go
    7. Check the `golang` version

           go version