grid {
    isUsed = false
    seleniumHub = '127.0.0.1:4444'
}

/*gmail {
    host = 'imap.gmail.com'
    mailStoreType = 'imaps'
    login = 'myservice.qa@gmail.com'
    password = 'P@rtnerpedia'
}*/

users {
    admin.login = ''
    password = ''
}
api {
    password = 'password'
    port = '8008'
}

environments {
    dflt {
        url = 'https://www.google.com'
    }
//    bvt {
//        url = 'http://clm-aus-009225.bmc.com:8008'
//        tenant = 'cokebvt.com'
//    }
//    psr {
//        url = 'http://vl-aus-sbe226.bmc.com:8008'
//        tenant = 'cokepsr.com'
//    }
}