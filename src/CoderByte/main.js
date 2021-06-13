const https = require('https');
/*
 * Complete the 'avgRotorSpeed' function below.
 *
 * URL for cut and paste
 * https://jsonmock.hackerrank.com/api/iot_devices/search?status={statusQuery}&page={number}
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. STRING statusQuery
 *  2. INTEGER parentId
 */

const getMyIOT_DataDevice = (statusQuery, pageNum, parentId) => {
    let tot_pages = 0;
    let getURL = `https://jsonmock.hackerrank.com/api/iot_devices/search?status=${statusQuery}&page=${pageNum}`
    return new Promise((resolve, reject) => {
        https.get(getURL, (res) => {
            res.setEncoding('utf8');
            res.on('data', function(body) {
                let dataRecords = JSON.parse(body);
                tot_pages = dataRecords.total_pages;
                let count_IOTDevices = dataRecords.data;
                const devices_filtered = count_IOTDevices.filter(device => device.parent);
                resolve({filteredDevices: devices_filtered, totalPages: tot_pages});
            });
            res.on('error', error => reject(error));
        });
    });
}

async function numDevices(statusQuery, parentId) {
    let myIotDevices_target = [];
    const {filteredDevices: devices_filtered, totalPages} = await getMyIOT_DataDevice(statusQuery, 0);
    myIotDevices_target.push(...devices_filtered);
    for(let j = 2; j <= totalPages; j ++) {
        const { filteredDevices: filData } = await getMyIOT_DataDevice(statusQuery, j);
        myIotDevices_target.push(...filData);
    }
    const devices_from_parent = myIotDevices_target.filter(item => item.parent.id === parentId);
    const sum = devices_from_parent.reduce((a, b) => a + b.operatingParams.rotorSpeed, 0);
    return devices_from_parent.length ? parseInt(sum / devices_from_parent.length, 10) : 0;
}