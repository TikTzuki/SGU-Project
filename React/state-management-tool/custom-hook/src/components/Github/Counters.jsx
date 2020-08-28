import React from "react";

import useGlobal from "../CustomHook/store";

const Counters = () => {
    const [globalState, globalActions] = useGlobal();
    const { request, success, fail } = globalState.counters;
    return (
        <p>
            {request} Requests <br/> {" "}
            <span className="success"> {success} Success</span> and {" "}
            <span className="fail"> {fail} Fails</span>
        </p>
    );
};

export default Counters;