package android.checkapp.data.mapper

import android.checkapp.data.remote.model.DataLoveReponse
import android.checkapp.data.remote.model.DataScore
import android.checkapp.domain.model.DomainLoveReponse
import android.checkapp.domain.model.DomainScore
import android.provider.ContactsContract

// #10  Data계층의 Response를 Domain계증의 Response로 변환해줌.
object MainMapper {

    fun loveMapper(
        // dataResponse를 파라미터로 받고 Domain Response를 리턴함.
        dataResponse : DataLoveReponse?
    ) : DomainLoveReponse? {
        return if (dataResponse != null){
            DomainLoveReponse(
                fname = dataResponse.fname,
                percentage = dataResponse.percentage,
                result = dataResponse.result,
                sname = dataResponse.sname
            )
        } else dataResponse
    }

    fun scoreMapper(
        domainResponse : DomainScore
    ) : DataScore {
        return DataScore(
            man = domainResponse.man
            , woman = domainResponse.woman
            , percentage = domainResponse.percentage
            , date = domainResponse.date
        )
    }

}